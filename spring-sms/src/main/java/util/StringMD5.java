package util;
// Created by ZhangJian on 18/3/12.

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class StringMD5 {
    // 对字符串加密: MD5 (方式一)
    public static String getStrMD5(String source) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(source.getBytes());
        byte[] md5Bytes = md.digest();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < md5Bytes.length; i++) {
            int t = md5Bytes[i] & 0xff;
            if (t <= 0xf) { // 16以下置为0
                res.append("0");
            }
            res.append(Integer.toHexString(t));
        }
        return res.toString();
    }

    // 对字符串加密: MD5 (方式二) 结果一样
    public static String getStringMD5(String input) throws NoSuchAlgorithmException {

        MessageDigest messageDigest = MessageDigest.getInstance("MD5"); // 拿到一个MD5转换器（如果想要SHA1参数换成”SHA1”）
        byte[] inputByteArray = input.getBytes();           // 输入的字符串转换成字节数组
        messageDigest.update(inputByteArray);               // inputByteArray是输入字符串转换得到的字节数组
        byte[] resultByteArray = messageDigest.digest();    // 转换并返回结果，也是字节数组，包含16个元素
        return byteArrayToHex(resultByteArray);
    }

    static String byteArrayToHex(byte[] byteArray) {
        // 首先初始化一个字符数组，用来存放每个16进制字符
        char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        // new一个字符数组，这个就是用来组成结果字符串的（解释一下：一个byte是八位二进制，也就是2位十六进制字符（2的8次方等于16的2次方）
        char[] resultCharArray = new char[byteArray.length * 2];
        int index = 0;
        // 遍历字节数组，通过位运算（位运算效率高），转换成字符放到字符数组中去
        for (byte b : byteArray) {
            // >>> 是无符号右移(忽略最高位符号位, 当成0), 高位补0, 下面是取8 bit的高位的4位
            resultCharArray[index++] = hexDigits[b >>> 4 & 0xf];
            resultCharArray[index++] = hexDigits[b & 0xf];
        }
        return new String(resultCharArray); // 字符数组转换成字符串返回
    }


    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println(getStrMD5("zhangxiaofanzhangxiaofanzhangxiaofanzhangxiaofanzhangxiaofanzhangxiaofanzhangxiaofan"));
        System.out.println(getStrMD5("zhangxiaofan"));

    }
}
