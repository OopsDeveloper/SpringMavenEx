package com.oopsdev.ex.generic;

public class BoxMethodEx {
    public static void main(String[] args) {
        Box<Integer> box1 = Util.<Integer>boxing(100);
        int intValue = box1.getT();
        System.out.println("intValue = " + intValue);

        Box<String> box2 = Util.boxing("고용수");
        String strValue = box2.getT();
        System.out.println("strValue = " + strValue);
    }
}
