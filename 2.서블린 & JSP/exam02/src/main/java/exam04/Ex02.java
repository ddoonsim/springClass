package exam04;

public class Ex02 {
    public static void main(String[] args) {
        Book2 b1 = Book2.builder()
                .title("제목1")
                .author("저자1")
                .publisher("출판사1")
                .build() ;

        System.out.println(b1);
    }
}
