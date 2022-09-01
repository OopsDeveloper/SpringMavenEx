package com.oopsdev.ex.stringmethod;

public class StringToLowerUpperCaseExample {
    public static void main(String[] args) {
        String str1 = "Java Programming";
        String str2 = "JAVA Programming";

        System.out.println(str1.equals(str2)); //false

        String lowerStr1 = str1.toLowerCase();
        String lowerStr2 = str2.toLowerCase();
        System.out.println(lowerStr1.equals(lowerStr2)); //true

        System.out.println(str1.equalsIgnoreCase(str2)); //true  대소문자 상관 없이 비교.
    }
}
