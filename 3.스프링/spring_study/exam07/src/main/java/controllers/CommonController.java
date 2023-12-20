package controllers;

import commons.CommonException;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @ControllerAdvice(범위)
 *  : 다른 컨트롤러 실행 전에 먼저 실행하는 컨트롤러
 */
@ControllerAdvice("controllers")
public class CommonController {

    @ExceptionHandler(Exception.class)
    public String errorHandler(Exception e, Model model, HttpServletResponse response) {  // 어떤 에러가 발생할지 모르기 때문에 Exception을 매개변수로

        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR ;  // 500
        if (e instanceof CommonException) {
            CommonException commonException = (CommonException)e ;
            status = commonException.getStatus() ;
        }
        response.setStatus(status.value());

        e.printStackTrace();
        model.addAttribute("message", e.getMessage());

        return "error/common";
    }
}
