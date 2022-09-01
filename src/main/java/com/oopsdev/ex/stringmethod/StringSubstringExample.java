package com.oopsdev.ex.stringmethod;

public class StringSubstringExample {
    public static void main(String[] args) {
        String ssn = "910311-1234567";

        String firstNum = ssn.substring(0, 6);
        System.out.println("firstNum = " + firstNum);

        String secondNum = ssn.substring(7);
    }
}
