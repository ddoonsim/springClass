package exam03;

import java.util.stream.IntStream;

public class Ex02 {
    public static void main(String[] args) {
        int oddTotal = IntStream.rangeClosed(1, 100).filter(x -> x % 2 == 1).sum() ;
        System.out.println(oddTotal);
    }
}
