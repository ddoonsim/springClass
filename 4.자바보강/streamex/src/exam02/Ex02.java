package exam02;

import java.util.Arrays;
import java.util.Comparator;

public class Ex02 {
    public static void main(String[] args) {
        int[] nums = { 11, 5, 3, 22, 115, 88, 76 } ;

        // boxed() : Stream<Integer> 으로 변환
        int[] nums2 = Arrays.stream(nums).boxed().sorted(Comparator.reverseOrder())
                .mapToInt(x -> x).toArray() ;

        System.out.println(Arrays.toString(nums2));
    }
}
