package com.util;

/**
 * @Description:发邮件
 * @author: fengjk
 * @time:2017年4月20日 下午7:42:35
 */

public interface EmailSender {

    /**
     * 同步发送, 等待发送结果(阻塞)
     * @param to
     * @param content
     * @param subject
     * @param html
     * @return
     */
    public boolean send(String[] to, String content, String subject, boolean html);

    /**
     * 异步发送, 不等待发送结果(非阻塞), 且设置异步发送线程的超时时间, 不影响主线程的执行
     * @param to
     * @param content
     * @param subject
     * @param html
     */
    public void sendAsyn(final String[] to, String content, String subject, boolean html);
}
