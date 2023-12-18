package exam01;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Ex04 {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("aa", "bb", "cc");
        List<String> result = map(words, s -> s.toUpperCase());
        System.out.println(result);
    }

    public static List<String> map(List<String> words, UnaryOperator<String> oper) {
        List<String> converted = new ArrayList<>();
        for (String word : words) {
            String word2 = oper.apply(word);
            converted.add(word2);
        }

        return converted;
    }
}