package controllers.member;

import models.member.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class MemberController {

    @GetMapping("/member/join")
    public String join(Model model) {
        // join에만 적용할 스타일과 자바스크립트 파일
        String[] addCss = {"member/style1", "member/style2"} ;
        List<String> addScript = Arrays.asList("member/script1", "member/script2") ;
        model.addAttribute("addCss", addCss) ;
        model.addAttribute("addScript", addScript) ;
        model.addAttribute("pageTitle", "회원가입") ;

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

    /**
     * 멤버 출력 연습
     */
    @GetMapping("/member/list")
    public String members(Model model) {
        List<Member> members = new ArrayList<>() ;
        for (int i = 1; i <= 10; i++) {
            Member member = Member.builder()
                    .userNo(Long.valueOf(i))
                    .userPw("1234")
                    .userId("user" + i)
                    .userNm("사용자" + i)
                    .email("user" + i + "@test.org")
                    .regDt(LocalDateTime.now())
                    .build() ;
            members.add(member) ;
        }
        model.addAttribute("members", members) ;

        return "member/list" ;
    }
}
