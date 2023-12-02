package exam04;

/**
 * Builder 패턴의 개념 이해하기
 */
public class Book {
    private String title ;
    private String author ;
    private String publisher ;
    private Book() {}

    public static Builder builder() {
        return new Builder() ;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                '}';
    }

    /**
     * Builder 내부에서 Book 객체 조립
     */
    protected static class Builder {
        private Book instance = new Book() ;

        public Builder title(String title) {
            instance.title = title ;    // instance 객체의 title필드에 값 설정

            return this ;
        }
        public Builder author(String author) {
            instance.author = author ;

            return this ;
        }
        public Builder publisher(String publisher) {
            instance.publisher = publisher ;

            return this ;
        }

        public Book build() {
            return instance ;
        }
    }
}
