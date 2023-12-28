package exam02;

import java.util.Random;

public class Ex04 {
    public static void main(String[] args) {
        Random rand = new Random() ;
        //rand.ints().limit(10).forEach(System.out::println);
        rand.ints(10).forEach(System.out::println);
        rand.doubles().limit(5).forEach(System.out::println);
    }
}
