package exam04;

public class Ex01 {
    public static void main(String[] args) {
        // Book b1 = new Book() ;  <-- 직접 생성 불가
        Book b2 = Book.builder()
                .title("제목1")
                .author("저자1")
                .publisher("출판사1")
                .build() ;

        System.out.println(b2);
    }
}
