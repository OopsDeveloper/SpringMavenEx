package com.oopsdev.ex.stringmethod;

public class StringReplaceExample {
    public static void main(String[] args) {
        String oldStr = "자바는 객체지향언어 입니다. 풍부한 API를 지원합니다.";
        String newStr = oldStr.replace("자바", "JAVA");
        System.out.println("oldStr = " + oldStr);
        System.out.println("newStr = " + newStr);
    }
}
