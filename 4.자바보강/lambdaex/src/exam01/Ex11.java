package exam01;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Ex11 {
    public static void main(String[] args) {
        //Supplier<Book> book = () -> new Book() ;
        Supplier<Book> book = Book::new ;

        List<String> names = Arrays.asList("이름1", "이름2", "이름3") ;
        //String[] names2 = names.stream().toArray(i -> new String[i]) ;
        String[] names2 = names.stream().toArray(String[]::new) ;
        System.out.println(Arrays.toString(names2));
    }
}
