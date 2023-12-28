package exam01;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Ex03 {
    public static void main(String[] args) {
        int total = IntStream.rangeClosed(1, 100).sum();
        System.out.println(total);

        List<String> words = Arrays.asList("aa", "bb", "cc");
        List<String> words2 = words.stream().map(s -> s.toUpperCase()).toList();
        System.out.println(words2);
    }
}