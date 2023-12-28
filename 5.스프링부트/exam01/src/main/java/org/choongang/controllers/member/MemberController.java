package org.choongang.controllers.member;

import lombok.extern.slf4j.Slf4j;
import org.choongang.entities.Member;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

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

    @ResponseBody    // 특정 메서드만 REST 요청 방식으로 바꿀 때
    @GetMapping("/info")
    public Member info() {
        Member member = Member.builder()
                .userNo(1L)
                .userId("user01")
                .userPw("12345678")
                .userNm("사용자01")
                .email("user01@test.org")
                .regDt(LocalDateTime.now())
                .modDt(LocalDateTime.now())
                .build() ;

        return member ;
    }
}
