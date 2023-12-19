package models.member;

import controllers.member.RequestLogin;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final MemberDao memberDao ;
    private final HttpSession session ;

    public void login(RequestLogin form) {
        /**
         * 1. 아이디로 회원 조회
         * 2. 세션에 회원 정보 유지
         */

        // 아이디로 회원 조회
        String userId = form.userId();
        Member member = memberDao.get(userId) ;

        // 세션에 회원 정보 유지
        session.setAttribute("member", member);
    }
}
