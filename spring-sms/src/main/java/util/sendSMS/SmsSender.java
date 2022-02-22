package util.sendSMS;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-01-25
 */
public interface SmsSender {

    boolean sendSMS(String telephone, String code, String timeout) throws Exception;
}
