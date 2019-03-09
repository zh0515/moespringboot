package cn.dev.util;

import sun.misc.BASE64Encoder;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class MD5 {
    public static boolean checkpassword(String newpasswd, String oldpasswd) {
        return EncoderByMd5(newpasswd).equals(oldpasswd);
    }

    public static String EncoderByMd5(String str) {
        //确定计算方法
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            BASE64Encoder base64en = new BASE64Encoder();
            //加密后的字符串
            String newstr = base64en.encode(md5.digest(str.getBytes(StandardCharsets.UTF_8)));
            return newstr;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
