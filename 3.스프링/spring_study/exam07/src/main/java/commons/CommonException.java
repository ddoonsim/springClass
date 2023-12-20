package commons;

import org.springframework.http.HttpStatus;

public class CommonException extends RuntimeException {

    private HttpStatus status ;

    /**
     * 기본 에러는 500으로 설정
     * @param message
     */
    public CommonException(String message) {
        this(message, HttpStatus.INTERNAL_SERVER_ERROR) ;    // 500에러
    }

    /**
     * 500 이외에 다른 예외 직접 정의하는 경우
     * @param message
     * @param status
     */
    public CommonException(String message, HttpStatus status) {
        super(message);
        this.status = status ;
    }

    public HttpStatus getStatus() {
        return status ;
    }
}
