package exam03;

import java.util.Optional;

public class Ex05 {
    public static void main(String[] args) {
        Optional<Book> book = Optional.ofNullable(null) ;
        //Book b = book.orElseGet(() -> new Book()) ;
        Book b = book.orElseGet(Book::new) ;
    }
}
