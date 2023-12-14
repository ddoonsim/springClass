package exam01;

import java.io.PrintStream;
import java.util.Objects;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Ex10 {
    public static void main(String[] args) {
        // Consumer<String> func1 = s -> System.out.println(s) ;
        Consumer<String> func1 = System.out::println ;

        // Function<String, Integer> func2 = s -> s.length() ;
        Function<String, Integer> func2 = String::length ;

        // BiPredicate<String, String> func3 = (s1, s2) -> s1.equals(s2) ;
        BiPredicate<String, String> func3 = Objects::equals;
    }
}
