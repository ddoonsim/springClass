package controllers.admin;

import lombok.RequiredArgsConstructor;
import models.member.Member;
import models.member.MemberDao;
import models.member.MemberNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller("adminMemberController")
@RequestMapping("/admin/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberDao memberDao ;

    @GetMapping    // /admin/member로 접속
    public String index(@ModelAttribute MemberSearch search, Errors errors, Model model) {

        List<Member> members = memberDao.getList(search) ;
        model.addAttribute("members", members) ;
        members.forEach(System.out::println);

        return "admin/member/list" ;
    }

    // /admin/member/회원아이디
    @GetMapping("/{id}")
    public String info(@PathVariable("id") String userId) {
        System.out.println(userId);

        return "admin/member/info" ;
    }

    @GetMapping("/test")
    public String errorTest() {
        boolean result = true;
        if (result) {
            throw new MemberNotFoundException();
        }

        return "admin/member/info";
    }

    /*@ExceptionHandler(Exception.class)
    public String errorHandler(Exception e, Model model) {
        e.printStackTrace();
        model.addAttribute("message", e.getMessage()) ;

        return "error/common" ;
    }*/
}
