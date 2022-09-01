package com.oopsdev.ex.stringmethod;

import java.io.UnsupportedEncodingException;

public class StringGetBytesExample {
    public static void main(String[] args) {
        String str = "안녕하세요";

        byte[] bytes1 = str.getBytes();
        System.out.println("bytes.length: " + bytes1.length);

        String str1 = new String(bytes1);
        System.out.println("str1 = " + str1);

        try {
            byte[] bytes2 = str.getBytes("UTF-8");
            //UTF-8 한글 한자를 3byte로 해석
            System.out.println("bytes2.length: " + bytes2.length);
            String str2 = new String(bytes2);
            System.out.println("str2 = " + str2);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }

    }
}
