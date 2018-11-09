package JavaTest;

import com.alibaba.fastjson.JSONObject;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

/**
 * Created by
 *
 * @author :   zhangjian
 * @date :   2018-06-15
 */

public class Test {

    public static void main(String[] args) {

        System.out.println(isValidEmailAddress("2585234@54@qq.com"));

    }


    public static boolean isValidEmailAddress(String email) {
        boolean isValidate = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex) {
            isValidate = false;
        }
        return isValidate;
    }
}
