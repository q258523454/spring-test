package util;
/**
 * 邮件发送接口
 * @author 
 * @email 
 * @date 
 * @version 1.0
 */
public interface IEmailSender {
	/**
	 * 邮件发送
	 * @param from 发送人
	 * @param to 接收人
	 * @param content 邮件内容
	 * @param subject 邮件主题
	 * @param html true:html 格式  false:文本
	 */
	public boolean send(String from, String to, String content, String subject, boolean html);


    /**
     * 异步发送, 不等待发送结果(非阻塞), 且设置异步发送线程的超时时间, 不影响主线程的执行
     * @param to
     * @param content
     * @param subject
     * @param html
     */
    public void sendAsyn(final String from, final String to, String content, String subject, boolean html);

}
