package exam04;

import java.util.Arrays;

public class Ex03 {
    public static void main(String[] args) {
        int[] nums = { 22, 15, 8, 79, 33 } ;
        int min = Arrays.stream(nums).reduce(Integer.MAX_VALUE, (a, b) -> a > b ? b : a) ;
        System.out.println(min);
    }
}
