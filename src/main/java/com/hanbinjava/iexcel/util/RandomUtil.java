package com.hanbinjava.iexcel.util;

import java.security.SecureRandom;
import java.util.Base64;

public class RandomUtil {

    /**
     * 生成安全token
     * @param bitLength
     * @return
     */
    public static String generateToken(int bitLength){
        SecureRandom secureRandom = new SecureRandom();
        byte[] bytes = new byte[bitLength/8];
        secureRandom.nextBytes(bytes);
        return Base64.getEncoder().encodeToString(bytes);
    }

//    public static void main(String[] args) {
//        System.out.println(generateToken(256));
//    }
}
