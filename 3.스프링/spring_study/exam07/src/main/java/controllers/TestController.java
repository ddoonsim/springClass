package controllers;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 쿠키 연습
 */
@Controller
public class TestController {

    @GetMapping("/cookie/test1")
    public String test1(HttpServletResponse response, HttpServletRequest request) {
        Cookie cookie = new Cookie("key1", "value1") ;
        response.addCookie(cookie);

        Cookie cookie2 = new Cookie("key2", "value2") ;
        cookie2.setPath(request.getContextPath());   // /exam07
        cookie2.setMaxAge(60 * 60 * 24 * 7);
        //cookie2.setMaxAge(0);   // 쿠키 삭제
        cookie2.setHttpOnly(true);  // false -> 자바스크립트로 브라우저에서만 조회 가능
                                    // true -> 자바스크립터 조회 X, 서버쪽에서만 요청을 통해 // 기본

        response.addCookie(cookie2);

        return "test" ;
    }

    @GetMapping("/cookie1/test2")
    public String test2(@CookieValue("key2") String key2) {
        System.out.printf("key2 = %s%n", key2);
        return "test" ;
    }

    @GetMapping("/session/test1")
    public String test3(HttpSession session) {
        session.setAttribute("key1", "value1");
        return "test" ;
    }

    @GetMapping("session/test2")
    public String test4(HttpServletRequest request) {
        HttpSession session = request.getSession();

        String value = session.getAttribute("key1").toString() ;
        System.out.printf("key1 = %s%n", value);

        return "test" ;
    }
}
