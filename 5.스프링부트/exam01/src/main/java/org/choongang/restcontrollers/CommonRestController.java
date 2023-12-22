package org.choongang.restcontrollers;

import org.choongang.commons.CommonException;
import org.choongang.commons.JSONData;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice("org.choongang.restcontrollers")
    // restcontrollers의 하위 객체들이 실행 전에 공통으로 먼저 실행되는 컨트롤러 부분(JSON 형식)
public class CommonRestController {

    @ExceptionHandler(Exception.class)
    /**
     * 예외 공통 처리, CommonException을 이용
     */
    public ResponseEntity<JSONData> errorHandler(Exception e) {
        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR ;  // 500 기본 설정

        // 응답 코드가 500 이외에
        if (e instanceof CommonException) {
            CommonException commonException = (CommonException) e ;    // 형 변환
            status = commonException.getStatus() ;    // 응답 코드 변경
        }

        e.printStackTrace();

        JSONData<Object> data = new JSONData<>() ;
        data.setStatus(status);
        data.setMessage(e.getMessage());
        data.setSuccess(false);    // 에러 발생 시, success = false로 변경

        return ResponseEntity.status(status).body(data) ;
    }
}
