package controllers.member;

import models.member.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;

@Controller
public class MemberController {

    @GetMapping("/member/join")
    public String join(Model model) {
        Member member = Member.builder()
                            .userNo(1L)
                            .userPw("1234")
                            .userId("user01")
                            .userNm("사용자01")
                            .email("user01@test.org")
                            .regDt(LocalDateTime.now())
                            .build() ;

        model.addAttribute("member", member) ;

        return "member/join" ;
    }

    @PostMapping("/member/join")
    public String joinPs(RequestJoin form) {
        System.out.println(form);
        return "member/join" ;
    }

    @GetMapping("member/login")
    public String login() {
        return "member/login" ;
    }

    @PostMapping("member/login")
    public String loginPs(RequestLogin form) {
        System.out.println(form);
        return "member/login" ;
    }
}
