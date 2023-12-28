package exam03;

import java.util.Comparator;
import java.util.TreeSet;

public class Ex03 {
    public static void main(String[] args) {

        /*
        Comparator<Integer> comp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1 ;  // 내림차순
            }
        };
        */

        TreeSet<Integer> numbers = new TreeSet<>(Comparator.reverseOrder()) ;  // 내림차순
        numbers.add(10) ;
        numbers.add(5) ;
        numbers.add(33) ;
        numbers.add(3) ;

        System.out.println(numbers);
    }
}