package com.oopsdev.ex.regexp;

import java.util.regex.Pattern;

public class PatternEx {
    public static void main(String[] args) {
        // 자바에서 \는 특수한 용도로 사용하므로 순수하게 \를 사용하기 위해 \\를 넣음
        // ? 없음 또는 한개
        String regExp = "(02|010)-\\d{3,4}-\\d{4}";
        String data = "010-1234-5678";

        boolean result = Pattern.matches(regExp, data);
        if (result) {
            System.out.println("정규식과 일치");
        } else {
            System.out.println("정규식과 일치하지 않음");
        }

        regExp = "\\w+@\\w+\\.\\w+(\\.\\w+)?";
        data = "angel@naver.com";

        result = Pattern.matches(regExp, data);
        if (result) {
            System.out.println("정규식과 일치");
        } else {
            System.out.println("정규식과 일치하지 않음");
        }
    }
}
