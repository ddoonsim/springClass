package exam04;

import java.io.Serializable;

public class Book implements Serializable {    // 객체 입출력을 위한 직렬화를 위한 인터페이스 구현
    private String title ;
    private String author ;
    private String publisher ;

    public Book(String title, String author, String publisher) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                '}';
    }
}
