package com.oopsdev.ex.stringmethod;

public class StringBuilderBufferExample {
    public static void main(String[] args) {
        // StringBuffer : 멀티 쓰레드
        // StringBuilder : 단일 쓰레드
        StringBuilder sb = new StringBuilder();
        sb.append("Java ");
        sb.append("Program Study");
        System.out.println(sb.toString());

        sb.insert(4, "2");
        System.out.println(sb.toString());

        sb.setCharAt(4,'6');
        System.out.println(sb.toString());

        sb.replace(6, 13, "Book");
        System.out.println(sb.toString());

        sb.delete(4, 5);
        System.out.println(sb.toString());

        int length = sb.length();
        System.out.println("총 문자수 = " + length);

        String result = sb.toString();
        System.out.println("result = " + result);
    }
}
