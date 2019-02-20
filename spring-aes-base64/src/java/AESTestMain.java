public class AESTestMain {

    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {
        String src = "a";
        String encryptionKey = "123456789X123456";
        String encrypted = AESUtil.encrypt(src, encryptionKey);
        String decrypted = AESUtil.decrypt(encrypted, encryptionKey);
        System.out.println("src: " + src);
        System.out.println("encrypted: " + encrypted);
        System.out.println("decrypted: " + decrypted);
    }

}
