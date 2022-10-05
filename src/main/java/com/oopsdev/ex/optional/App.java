package com.oopsdev.ex.optional;

import com.oopsdev.ex.stream.OnlineClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class App {
    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "onlineClass boot", true));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        Optional<OnlineClass> optional = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("jpa"))
                .findFirst();

        boolean present = optional.isPresent(); //java11에서는 isEmpty 지원
        System.out.println(present);

        //optional에 get은 값이 들어있으면 아무 문제가 없지만
        //값이 없을 떄 NoSuchElementException(런타임쪽) 문제가 되서 가급적이면 쓰지 않는다.

        //optional.ifPresent(oc -> System.out.println(oc.getTitle())); //consumer
        //OnlineClass onlineClass = optional.orElse(createNewJpaClass()); //조건이 맞더라도 현재 else부분이 실행되는 구문...
        //System.out.println(onlineClass.getTitle());

        OnlineClass onlineClass = optional.orElseGet(() -> createNewJpaClass()); //supplier
        System.out.println(onlineClass.getTitle());

        /*
        * 이미 상수로 만들어져 있는것을 참고해서 사용할 때는 orElse()가 맞고
        * 동적으로 작업을 만들거나 추가해야될 떄는 orElseGet()을 사용
        */
/*
        OnlineClass onlineClass1 = optional.orElseThrow(() -> {
            return new IllegalArgumentException();
        });
        OnlineClass onlineClass1 = optional.orElseThrow(() -> new IllegalArgumentException());
        */

        OnlineClass onlineClass1 = optional.orElseThrow(IllegalArgumentException::new);



        Optional<Progress> progress = optional.flatMap(OnlineClass::getProgress);
        Optional<Optional<Progress>> progress1 = optional.map(OnlineClass::getProgress);
        Optional<Progress> progress2 = progress1.orElse(Optional.empty());


    }

    private static OnlineClass createNewJpaClass() {
        System.out.println("creating new online class");
        return new OnlineClass(10, "new Class", false);
    }
}
