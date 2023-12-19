package commons;

import jakarta.servlet.http.HttpSession;
import models.member.Member;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 편의성 기능 추가
 */
public class Utils {

    @Autowired
    private HttpSession session ;

    /**
     * 세션에 값이 있으면 로그인 상태 O
     * 세션에 값이 없으면 로그인 상태 X
     */
    public boolean isLogin() {
        return getMember() != null ;
    }

    /**
     * 세션에 담겨 있는 회원 정보를 쉽게 가져오는 편의 메서드
     */
    public Member getMember() {
        Member member = (Member) session.getAttribute("member") ;
        return member ;
    }
}
