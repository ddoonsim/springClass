package org.choongang.commons;

import org.springframework.http.HttpStatus;

// 자주 사용되는 예외 따로 클래스를 만듦
public class BadRequestException extends  CommonException {

    public BadRequestException(String message) {
        super(message, HttpStatus.BAD_REQUEST);  // 응답 코드 고정
    }
}
