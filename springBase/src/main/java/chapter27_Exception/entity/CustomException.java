package chapter27_Exception.entity;

/**
 * Created By
 *
 * @author :   zhangj
 * @date :   2019-01-28
 */
public class CustomException extends Exception {

    private String msg;

    public CustomException(String msg) {
        super();
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
}