package exam03;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toMap;

public class Ex08 {
    public static void main(String[] args) {
        List<Book> books = IntStream.rangeClosed(1, 10).mapToObj( i ->
                new Book("책" + i, "저자" + i, "출판사" + i)).toList() ;

        Map<String, String> data = books.stream()
                .collect(toMap(Book::getAuthor, Book::getTitle)) ;

        data.entrySet().stream()
                .forEach( e -> System.out.printf("key = %s, value = %s%n", e.getKey(), e.getValue()));
    }
}
