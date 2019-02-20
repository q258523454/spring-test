import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public enum AESUtil {
    ;

    public static String encrypt(String src, String encryptionKey) throws Exception {
        try {
            if (encryptionKey == null) {
                throw new Exception("key is null");
            }

            // 判断Key是否为16位
            if (encryptionKey.length() != 16) {
                throw new Exception("key length must be 16");
            }

            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");     //"算法/模式/补码方式"
            cipher.init(Cipher.ENCRYPT_MODE, makeKey(encryptionKey));
            byte[] encrypted = cipher.doFinal(src.getBytes("utf-8"));
            return new BASE64Encoder().encodeBuffer(encrypted);             //此处使用BASE64做转码功能，同时能起到2次加密的作用。
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String decrypt(String src, String encryptionKey) {
        String decrypted = "";
        try {
            Cipher cipher = Cipher.getInstance("aes");
            cipher.init(Cipher.DECRYPT_MODE, makeKey(encryptionKey));
            BASE64Decoder base64Decoder = new BASE64Decoder();
            decrypted = new String(cipher.doFinal(base64Decoder.decodeBuffer(src)));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return decrypted;
    }

    static Key makeKey(String encryptionKey) {
        try {
            byte[] raw = encryptionKey.getBytes("utf-8");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            return skeySpec;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    // 无需固定密钥长度, MessageDigest固定生成
    static Key makeStringKey(String encryptionKey) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] key = md.digest(encryptionKey.getBytes("UTF-8"));
            return new SecretKeySpec(key, "aes");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
