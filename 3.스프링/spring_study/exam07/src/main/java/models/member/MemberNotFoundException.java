package models.member;

import commons.CommonException;
import org.springframework.http.HttpStatus;

public class MemberNotFoundException extends CommonException {

    /**
     * 404 에러인 경우
     */
    public MemberNotFoundException() {
        super("등록되지 않은 회원입니다.", HttpStatus.NOT_FOUND);    // 404에러
    }
}
