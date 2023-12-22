package org.choongang.restcontrollers;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

/**
 * 커맨드 객체 : 회원가입에 필요한 데이터 객체
 */
@Data
public class RequestJoin {

    @NotBlank(message = "아이디를 입력하세요.")  // 필수 입력 항목 검증
    private String userId ;
    @NotBlank(message = "비밀번호를 입력하세요.")
    private String userPw ;
    @NotBlank(message = "비밀번호를 확인하세요.")
    private String confirmPw ;
    @NotBlank(message = "회원명을 입력하세요.")
    private String userNm ;
    private String email ;
}
