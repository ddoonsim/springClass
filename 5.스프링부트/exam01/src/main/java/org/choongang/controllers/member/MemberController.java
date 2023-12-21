package org.choongang.controllers.member;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j    // log 변수 추가 --> 로그 기록
@Controller
@RequestMapping("/member")
public class MemberController {

    @GetMapping("/join")
    public String join() {
        log.info("로그 메세지!");    // info 레벨로 로그를 기록
        log.info("로그 {}, {}", "값1", "값2");   // {} : 치환되는 부분
            // 첫 번째 {} <- 값1, 두 번째 {} <- 값2  ==> "로그 값1, 값2"로 콘솔에 출력됨

        return "/member/join" ;
    }
}
