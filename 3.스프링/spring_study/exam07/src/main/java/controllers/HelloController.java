package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller  // 요청과 응답을 중재 역할하는 빈
public class HelloController {

    /**
     * 요청 메서드
     */
    @GetMapping("/hello")
    public String hello(@RequestParam("name") String name,
                        @RequestParam("num") int num) {  // 요청 파라미터(쿼리스트링)를 name에 대입
        System.out.println(name + ", " + num);
        return "hello" ;   // /WEB-INF/templates/hello.jsp
    }

    /**
     * 요청에 의해 실행하는 메서드
     * @return ModelAndView 객체 : 데이터와 출력될 결과를 담고 있는 객체

    @GetMapping("/hello")    // 요청 방식과 url에 대한 정보를 전달하는 어노테이션
    public ModelAndView hello() {
        ModelAndView mv = new ModelAndView() ;
        mv.addObject("message", "안녕하세요😊") ;   // 데이터를 request영역에 속성 추가 --> el식으로 이용이 가능해짐
        // request.setAttribute("message", "안녕하세요.") ;와 같지만
        // Addapter가 자동 형 변환 수행
        mv.setViewName("hello");   // /WEB-INF/templates/hello.jsp View에 대한 경로를 ViewResolver에 전달

        return mv ;
    }*/
}
