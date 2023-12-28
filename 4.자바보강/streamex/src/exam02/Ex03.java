package exam02;

import java.util.stream.IntStream;

public class Ex03 {
    public static void main(String[] args) {
        IntStream.range(0, 10).forEach(i -> System.out.println("반복 " + i + "번"));
        System.out.println("===================");
        IntStream.rangeClosed(1, 10).forEach(i -> System.out.println("반복 " + i + "번"));

        int total = IntStream.rangeClosed(1, 100).sum();
        System.out.println("1 ~ 100까지의 합계 : " + total);
    }
}
