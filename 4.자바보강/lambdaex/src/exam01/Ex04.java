package exam01;

import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;

public class Ex04 {
    public static void main(String[] args) {
        //Function<Integer, Integer> function = x -> x * x ;
        //UnaryOperator<Integer> function = x -> x * x ;
        IntUnaryOperator function = x -> x * x ;
        int result = function.applyAsInt(100);
        System.out.println(result);
    }
}
