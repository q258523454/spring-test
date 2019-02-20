package JavaTest;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


/**
 * Created by
 *
 * @author :   zhangjian
 * @date :   2018-06-15
 */

public class Test {

    public static void main(String[] args) throws Exception {
        String encryptionKey = "123";
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] key = md.digest(encryptionKey.getBytes("UTF-8"));
        String a = new String(key,"UTF-8");
        System.out.println(a);
    }
}
