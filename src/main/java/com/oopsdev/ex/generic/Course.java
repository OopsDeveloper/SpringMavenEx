package com.oopsdev.ex.generic;

public class Course<T> {
    private String name;
    private T[] students;

    //자바에서는 T가 결정이 안된상태에서 T타입 배열을 만들 수 없다.
    //T타입 배열로 만들려면 -> Object배열로 만들고 T타입으로 강제타입변환.
    public Course(String name, int capacity) {
        this.name = name;
        students = (T[])(new Object[capacity]);
    }

    public String getName() {
        return name;
    }

    public T[] getStudents() {
        return students;
    }

    public void add(T t) {
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                students[i] = t;
                break;
            }
        }
    }
}
