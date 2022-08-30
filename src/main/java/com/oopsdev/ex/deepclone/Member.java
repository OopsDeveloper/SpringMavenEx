package com.oopsdev.ex.deepclone;

import java.util.Arrays;

public class Member implements Cloneable{
    public String name;
    public int age;
    public int[] scores;
    public Car car;

    public Member(String name, int age, int[] scores, Car car) {
        this.name = name;
        this.age = age;
        this.scores = scores;
        this.car = car;
    }

    // clone시 class에 implements Cloneable 해야됨.
    // 깊은 복사는 객체까지 복사
    @Override
    protected Object clone() throws CloneNotSupportedException {
       Member cloned = (Member) super.clone(); // Object에 있는 clone을 얕은 복사 해야됨.(그냥 하게되면 재정의된 clone이 실행됨)
        cloned.scores = Arrays.copyOf(this.scores, this.scores.length);
        cloned.car = new Car(this.car.model);
        return cloned;
    }

    public Member getMember() {
        Member cloned = null;
        try {
            cloned = (Member) clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        return cloned;
    }

}
