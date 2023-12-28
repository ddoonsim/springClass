package exam01;

import java.util.Arrays;
import java.util.Comparator;

public class Ex03 {
    public static void main(String[] args) {
        Calculator cal = num -> num * num ;
        System.out.println(cal.square(5)) ;

        Integer[] nums = { 4, 15, 9, 37, 23 } ;
        Arrays.sort(nums, Comparator.reverseOrder());
        System.out.println(Arrays.toString(nums));
    }
}
