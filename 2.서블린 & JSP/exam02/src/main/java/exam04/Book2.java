package exam04;

import lombok.Builder;
import lombok.ToString;

@Builder    // Builder 패턴 자동 생성
@ToString
public class Book2 {
    private String title ;
    private String author ;
    private String publisher ;
}
