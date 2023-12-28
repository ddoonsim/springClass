package exam01;

import java.util.function.Function;

public class Ex08 {
    public static void main(String[] args) {
        Function<String, Integer> func1 = s -> s.length() ;  // 문자열 -> 문자열의 길이

        Function<Integer, Integer> func2 = x -> x * x * x ;  // 수 -> 세제곱

        Function<String, Integer> func3 = func1.andThen(func2) ;  // 함수1과 함수2 결합
        int num = func3.apply("ABC") ;
        System.out.println(num);

        Function<Integer, Integer> func4 = x -> x ;  // 넘어온 값을 그대로 내보내는 함수
        Function<Integer, Integer> func5 = Function.identity() ;
    }
}
