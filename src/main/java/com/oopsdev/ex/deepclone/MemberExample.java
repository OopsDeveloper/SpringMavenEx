package com.oopsdev.ex.deepclone;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MemberExample {
    public static void main(String[] args) {
        Member original = new Member("홍길동", 32, new int[]{90, 90}, new Car("소나타"));

        Member cloned = original.getMember();
        //원본을 유지하려면 깊은복사를 사용
        cloned.scores[0] = 100;
        cloned.car.model = "그랜저";
        cloned.age= 31;

        System.out.println("원본 객체의 필드값");
        System.out.println("name: " + original.name);
        System.out.println("age: " + original.age);
        System.out.print("scores: ");
        IntStream.range(0,original.scores.length)
                .forEach(index ->System.out.print(original.scores[index]+","));
        System.out.println("car: " + original.car.model);

        System.out.println("-----------------------");

        System.out.println("복제 객체의 필드값");
        System.out.println("name: " + cloned.name);
        System.out.println("age: " + cloned.age);
        System.out.print("scores: ");
        IntStream.range(0,cloned.scores.length)
                .forEach(index ->System.out.print(cloned.scores[index]+","));
        System.out.println("car: " + cloned.car.model);
    }
}
