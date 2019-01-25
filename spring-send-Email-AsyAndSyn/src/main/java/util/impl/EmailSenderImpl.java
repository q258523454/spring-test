package util.impl;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.util.StringUtils;
import util.IEmailSender;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.concurrent.*;

/**
 * 邮件发送实现类
 *
 * @author
 * @version 1.0
 * @email
 * @date
 */
public class EmailSenderImpl implements IEmailSender {

    // 由spring注入邮件的发送对象
    private JavaMailSender javaMailSender;

    private String from;

    public void setJavaMailSender(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }


    /**
     * 邮件发送
     *
     * @param from    发送人
     * @param to      接收人
     * @param content 邮件内容
     * @param subject 邮件主题
     * @param html    true:html 格式  false:文本
     */
    @Override
    public boolean send(String from, String to, String content, String subject, boolean html) {
        boolean flag = true;
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "UTF-8");
            if (null == from || "".equals(from)) {
                message.setFrom(this.from); // 发送人
            } else {
                message.setFrom(from); // 发送人
            }
            message.setTo(to);                          // 接收人
            message.setSubject(subject);                // 主题
            message.setText(content, html);             // 内容
            message.setSentDate(new Date());            // 发送日期
            javaMailSender.send(mimeMessage);           // 发送邮件
        } catch (MessagingException e) {
            flag = false;
            e.printStackTrace();
            //throw new RuntimeException("发送邮件时出现异常！", e);
        } finally {
            return flag;
        }
    }

    @Override
    public void sendAsyn(final String from, final String to, final String content, final String subject, final boolean html) {
        final ExecutorService mainExecutorService = Executors.newSingleThreadExecutor();
        mainExecutorService.execute(new Runnable() {
            public void run() {
                Runnable myRunnable = new Runnable() {
                    public void run() {
                        if (!Thread.currentThread().isInterrupted()) {
                            try {
                                boolean flag = send(from, to, content, subject, html);
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
                    // 嵌套子线程-发送邮件-超时时间设置为60秒
                    String res = future.get(60 * 1000, TimeUnit.MILLISECONDS);   // 设置嵌套线程的超时时间(一般邮箱发送的超时时间)
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (TimeoutException e) {
                    e.printStackTrace();
                } finally {
                    future.cancel(true);  // 经过测试, 里面包含了方法:thread.interrupt()
                    executorService.shutdownNow();          // 中断线程
                    Thread.currentThread().interrupt();
                }
            }
        });

        // 下面代码必须, 否则嵌套线程不会停止
        mainExecutorService.shutdown(); // 线程池的状态立刻变成STOP状态，此时不能再往线程池中添加新的任务,试图停止所有正在执行的线程，试图终止的方法是调用Thread.interrupt()
    }
}
