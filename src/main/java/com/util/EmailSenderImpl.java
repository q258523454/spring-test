package com.util;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.concurrent.*;


@Service
public class EmailSenderImpl implements EmailSender {

    public static Logger log = Logger.getLogger(EmailSenderImpl.class);

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${mail.default.from:defaultValue}")
    private String from;

    @Value("${mail.smtp.auth:defaultValue}")
    private String mailTimeout;


    /**
     * 同步发送, 等待发送结果(阻塞)
     *
     * @param to
     * @param content
     * @param subject
     * @param html
     * @return
     */
    @Override
    public boolean send(String[] to, String content, String subject, boolean html) {
        boolean flag = true;
        try {
            for (long i = 0; i < Long.MAX_VALUE/Integer.MAX_VALUE; i++) {
                // TODO 2秒

            }
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "UTF-8");
            message.setFrom(this.from);             // sender: From address must be same as authorization user
            message.setTo(to);                      // receiver lists
            message.setSubject(subject);            // subject
            message.setText(content, html);         // content
            message.setSentDate(new Date());        // send date
            for (int i = 0; i < to.length; i++) {
                log.info("Email Sender: From {" + message.getMimeMessage().getFrom()[0] + "} to {" + message.getMimeMessage().getAllRecipients()[i] + "}");
            }
            javaMailSender.send(mimeMessage); // Sending
            log.info("Email Send Finished.");

        } catch (Exception e) {
            flag = false;
            e.printStackTrace();
        } finally {
            return flag;
        }
    }


    /**
     * 异步发送, 不等待发送结果(非阻塞), 且设置异步发送线程的超时时间, 不影响主线程的执行
     *
     * @param to
     * @param content
     * @param subject
     * @param html
     */
    @Override
    public void sendAsyn(final String[] to, final String content, final String subject, final boolean html) {
        final ExecutorService mainExecutorService = Executors.newSingleThreadExecutor();
        log.info("AAAAAAAAAAAAAAAA");

        mainExecutorService.execute(new Runnable() {
            public void run() {
                Runnable myRunnable = new Runnable() {
                    public void run() {
                        if (!Thread.currentThread().isInterrupted()) {
                            try {
                                boolean flag = send(to, content, subject, html);
                                if (false == flag) {
                                    // 异步邮件发送失败
                                    throw new RuntimeException();
                                }
                            } catch (Exception e) {
                                // 异步邮件发送失败
                                e.printStackTrace();
                                throw new RuntimeException();
                            }
                        }
                    }
                };

                ExecutorService executorService = Executors.newSingleThreadExecutor();

                Callable callable = Executors.callable(myRunnable, "子线程-嵌套子线程(发送邮件)");
                FutureTask<String> future = new FutureTask(callable);
                executorService.execute(future);

                try {
                    String res = future.get(5000, TimeUnit.MILLISECONDS);   // 设置嵌套线程的超时时间(一般邮箱发送的超时时间)
                    log.info("子线程:" + Thread.currentThread().getName() + "完成{" + res + "}任务");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (TimeoutException e) {
                    log.error("嵌套线程-超时");
                    e.printStackTrace();
                } finally {
                    future.cancel(true);  // 经过测试, 里面包含了方法:thread.interrupt()
                    executorService.shutdownNow();          // 中断线程
                    Thread.currentThread().interrupt();
                    log.info("邮件发送-嵌套子线程-done");
                }
            }
        });

        // 下面代码必须, 否则嵌套线程不会停止
        mainExecutorService.shutdown(); // 线程池的状态立刻变成STOP状态，此时不能再往线程池中添加新的任务,试图停止所有正在执行的线程，试图终止的方法是调用Thread.interrupt()
        log.info("邮件发送-done");
    }
}
