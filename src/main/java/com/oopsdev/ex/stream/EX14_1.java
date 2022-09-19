package com.oopsdev.ex.stream;

import java.util.Comparator;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class EX14_1 {
    public static void main(String[] args) {
        Stream<Student> studentStream = Stream.of(
          new Student("이자바", 3, 300),
          new Student("김자바", 3, 200),
          new Student("안자바", 3, 190),
          new Student("박자바", 3, 150),
          new Student("소자바", 3, 200),
          new Student("나자바", 3, 290),
          new Student("감자바", 3, 180)
        );

        //역순 정렬은 studentStream.sorted(Comparator.comparing(Student::getBan).reversed()
        //studentStream.sorted(Comparator.comparing(Student::getBan) //반별 정렬 메소드 참조
        studentStream.sorted(Comparator.comparing((Student s)->s.getBan()) //반별 정렬
                .thenComparing(Comparator.naturalOrder())) //기본 정렬
                .forEach(System.out::println);
    }
}

class Student implements Comparable<Student> {
    String name;
    int ban;
    int totalScore;

    public Student(String name, int ban, int totalScore) {
        this.name = name;
        this.ban = ban;
        this.totalScore = totalScore;
    }

    @Override
    public String toString() {
        return String.format("[%s, %d, %d]", name, ban, totalScore);
    }

    public String getName() {
        return name;
    }

    public int getBan() {
        return ban;
    }

    public int getTotalScore() {
        return totalScore;
    }

    //총점 내림차순을 기본 정렬로 한다.
    @Override
    public int compareTo(Student s) {
        return s.totalScore - this.totalScore;
    }
}
