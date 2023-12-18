package controllers.member;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import models.member.JoinService;
import models.member.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/member")    // 공통된 url패턴 정의하고, 하단에서는 /member 명시 X
@RequiredArgsConstructor
public class MemberController {

    // 의존성 자동 주입 처리
    private final JoinValidator joinValidator ;
    private final JoinService joinService ;

    @GetMapping("/join")   // /member/join으로 매핑
    //@RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})  // 두 가지 매핑 방식 한번에 적용
    public String join(@ModelAttribute RequestJoin form, Model model) {  // rjoin으로 속성명 바꿈

        // 비어있더라도 객체 생성 필요 : NPE 예외 방지
        //model.addAttribute("requestJoin", new RequestJoin()) ;  <-- @ModelAttribute 어노테이션으로 자동화
        model.addAttribute("pageTitle", "회원가입") ;

        return "member/join" ;
    }


    @PostMapping("/join")
    public String joinPs(@Valid RequestJoin form, Errors errors, Model model) {
        // @Valid : 유효성 검증할 커맨드 객체임을 알려줌
        // Errors 객체는 반드시 커맨드 객체의 바로 뒤에 위치해야 함!!

        joinValidator.validate(form, errors);  // 유효성 검사 수행, 에러 => 에러 메세지 출력
        if (errors.hasErrors()) {
            // 검증 실패 시 실행 부분
            return "member/join" ;
        }

        // 유효성 검사 통과 => 회원 가입 처리
        joinService.join(form);

        //System.out.println(form);
        //model.addAttribute("requestJoin", form) ;
        // 커맨드 객체 RequestJoin -> requestJoin 이름으로 Model에 속성이 자동 추가
            // -> 템플릿 내에서 바로 접근 가능

        // 이동 방식 : response.sendRedirect(request.getContextPath() + "/member/login")
        // 개발자 도구에서 응답 헤더 중 Location : /exam07/member/login
        return "redirect:/member/login" ;
        //return "forward:/member/login" ;    <-- forward 방식으로 화면 전환
    }

    @GetMapping("/login")
    public String login() {
        return "member/login" ;
    }

    @PostMapping("/login")
    public String loginPs(RequestLogin form) {
        System.out.println(form);
        return "member/login" ;
    }

    /**
     * 멤버 출력 연습
     */
    @GetMapping("/list")
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
