package com.oopsdev.ex.hashcode;

public class MemberExample {
    public static void main(String[] args) {
        Member obj1 = new Member("blue");
        Member obj2 = new Member("blue");
        Member obj3 = new Member("red");

        if (obj1.equals(obj2)) {
            System.out.println("1,2 동등");
        } else {
            System.out.println("1,2 다름");
        }
        if (obj1.equals(obj3)) {
            System.out.println("1,3 동등");
        } else {
            System.out.println("1,3 다름");
        }

    }
}
