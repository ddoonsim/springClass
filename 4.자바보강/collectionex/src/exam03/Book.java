package exam03;

import java.util.Comparator;
import java.util.Objects;

public class Book implements Comparable<Book> {

    private String title ;
    private String author ;
    private String publisher ;

    public Book(String title, String author, String publisher) {
        this.title = title ;
        this.author = author ;
        this.publisher = publisher ;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title) && Objects.equals(author, book.author) && Objects.equals(publisher, book.publisher);
    }   // Objects : 객체의 편의 기능

    @Override
    public int hashCode() {
        return Objects.hash(title, author, publisher);
    }

    @Override
    public int compareTo(Book o) {
        // 음수 => 앞으로 배치, 양수 => 뒤로 배치, 0 => 동등
        // 현재 대상 - 비교 대상 : 오름차순
        // 비교 대상 - 현재 대상 : 내림차순
        //return title.hashCode() - o.title.hashCode() ;  // 오름 차순 정렬
        //return o.title.hashCode() - title.hashCode() ;  // 내림 차순 정렬
        //return title.compareTo(o.title) ;  // 오름차순
        //return o.title.compareTo(title) ;  // 내림차순
        return title.compareTo(o.title) * (-1);  // 내림차순
    }
}
