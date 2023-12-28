package controllers.member;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final JoinValidator joinValidator ;

    @GetMapping("/join")
    public String join(@ModelAttribute RequestJoin form, Model model) {
        model.addAttribute("pageTitle", "회원가입") ;

        //model.addAttribute("requestJoin", new RequestJoin()) ;
        return "member/join" ;
    }

    @PostMapping("/join")
    public String joinPs(@Valid RequestJoin form, Errors errors, Model model) {
        // 유효성 검증 수행할 객체 : JoinValidator
        joinValidator.validate(form, errors);
        if (errors.hasErrors()) {
            return "member/join" ;
        }
        return "redirect:login" ;
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "member/login" ;
    }
}
