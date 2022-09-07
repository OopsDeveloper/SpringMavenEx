package com.oopsdev.ex.generic;

public class BoundedTypeParameterEx {
    public static void main(String[] args) {
        int result = Util.compare(10, 20);
        System.out.println("result = " + result);

        int result2 = Util.compare(4.5, 3);
        System.out.println("result2 = " + result2);
    }
}
