package com.oopsdev.ex.stringmethod;

public class StringIndexOfExample {
    public static void main(String[] args) {
        String subject = "자바 프로그래밍";

        int location = subject.indexOf("프로그래밍");
        System.out.println("location = " + location);

        if (subject.indexOf("자바") != -1) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
