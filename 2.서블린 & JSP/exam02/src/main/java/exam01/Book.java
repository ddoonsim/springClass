package exam01;

import lombok.*;

/*@Getter
@Setter
@ToString
//@AllArgsConstructor    // 모든 필드를 생성자 매개변수로
//@NoArgsConstructor(access = AccessLevel.PRIVATE)     // 기본 생성자
@RequiredArgsConstructor    // 초기화가 반드시 필요한 멤버 변수를 매개변수로 하는 생성자
@EqualsAndHashCode
*/
@Data   // @Getter, @Setter, @ToString, @EqualsAndHashCode
public class Book {
    private String title ;
    private String author ;
    private String publisher ;

}
