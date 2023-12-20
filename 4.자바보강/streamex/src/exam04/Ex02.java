package exam04;

import java.util.Arrays;

public class Ex02 {
    public static void main(String[] args) {
        int[] nums = { 22, 15, 8, 79, 33 } ;
//        int max = Arrays.stream(nums).reduce(Integer.MIN_VALUE, (a, b) -> a > b ? a : b) ;
        int max = Arrays.stream(nums).reduce(Integer.MIN_VALUE, (a, b) -> {
            if (a > b) return a ;
            else return b ;
        }) ;
        System.out.println(max);
    }
}
