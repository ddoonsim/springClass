package controllers.member;

import lombok.Data;

import java.util.List;

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
    private List<String> hobby ;
    private Address addr ;    // addr 변수를 통해서(addr.addressSub) Address 커맨드 객체를 중첩시킴
    private boolean agree ;
}
