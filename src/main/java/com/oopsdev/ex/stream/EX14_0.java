package com.oopsdev.ex.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class EX14_0 {
    public static void main(String[] args) {
//        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
//        Stream<Integer> intStream = list.stream(); // list를 데이터 소스로 하는 새로운 스트림을 생성
//        intStream.forEach(System.out::print);
//
//        //stream은 1회용, stream에 대해 최종연산을 수행하면 stream이 닫힌다.
//        intStream = list.stream(); //새로운 스트림을 생성
//        intStream.forEach(System.out::print);

//        Stream<String> strStream = Stream.of("a","b","c"); //가변인자
//        strStream.forEach(System.out::println);"a","b","c");
//        Stream<String> strStream = Stream.of(new String[]{"a","b","c"}); //배열
        Stream<String> strStream = Arrays.stream(new String[]{"a", "b", "c"});
        strStream.forEach(System.out::println);

//
//        int[] intArr = {1, 2, 3, 4, 5};
//        IntStream intStream = Arrays.stream(intArr);
//        intStream.forEach(System.out::println);
////        System.out.println("count= " + intStream.count());
////        System.out.println("sum= " + intStream.sum());
//        System.out.println("average= " + intStream.average());

        // Stream<T>는 숫자 외에도 여러 타입의 스트림이 가능해야하므로 숫자 스트림에만 사용할 수 있는 sum(),average()를 넣지 않은 것
//        Integer[] intArr = {1, 2, 3, 4, 5};
//        Stream<Integer> intStream = Arrays.stream(intArr);
////        intStream.forEach(System.out::println);
//        System.out.println("count= " + intStream.count());


        IntStream intStream = new Random().ints(); //무한스트림
//        IntStream intStream = new Random().ints(5,10);
//        IntStream intStream = new Random().ints(10,5,10);
        intStream.limit(5).forEach(System.out::println);

        //iterate(T seed, UnaryOperator f) 단항 연산자
        Stream<Integer> integerStream = Stream.iterate(1, n -> n + 2);
        integerStream.limit(10).forEach(System.out::println);

        //generate(Supplier s) : 주기만 하는것 입력x,출력o
        Stream<Integer> oneStream = Stream.generate(() -> 1);
        oneStream.limit(5).forEach(System.out::println);


    }
}
