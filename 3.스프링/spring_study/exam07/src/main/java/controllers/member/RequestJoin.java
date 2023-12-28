package controllers.member;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

/**
 * 커맨드 객체 : 기능 요청을 자동으로 처리하고 추가 기능 수행
 * 유효성 검사를 위한 어노테이션도 추가
 */
@Data
public class RequestJoin {

    @NotBlank  // 입력 필수 항목
    @Size(min = 6)  // 6자리 이상
    private String userId ;
    @NotBlank
    @Size(min = 8)
    private String userPw ;
    @NotBlank
    private String confirmPw ;
    @NotBlank
    private String userNm ;
    @Email
    private String email ;
    @AssertTrue  // 참일 때만 유효성 검사 통과
    private boolean agree ;
}
