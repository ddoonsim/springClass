package org.choongang.commons;

import org.springframework.http.HttpStatus;

/**
 * 모든 예외들의 상위 클래스
 */
public class CommonException extends RuntimeException {
    private HttpStatus status ;

    // 에러 코드 500일 때
    public CommonException(String message) {
        this(message, HttpStatus.INTERNAL_SERVER_ERROR) ;  // 기본 예외는 500으로 설정
    }

    // 메세지와 응답 코드를 직접 설정할 수 있는 생성자
    public CommonException(String message, HttpStatus status) {
        super(message);
        this.status = status ;
    }

    /**
     * 응답 코드를 반환하는 메서드
     */
    public HttpStatus getStatus() {
        return status ;
    }
}
