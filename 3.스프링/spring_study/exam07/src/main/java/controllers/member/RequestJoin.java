package controllers.member;

import lombok.Data;

/**
 * 커맨드 객체 : 기능 요청을 자동으로 처리하고 추가 기능 수행
 */
@Data
public class RequestJoin {

    private String userId ;
    private String userPw ;
    private String confirmPw ;
    private String userNm ;
    private String email ;
    private boolean agree ;
}
