package controllers.member;

import lombok.RequiredArgsConstructor;
import models.member.Member;
import models.member.MemberDao;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class LoginValidator implements Validator {

    private final MemberDao memberDao ;

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(RequestLogin.class) ;
    }

    /**
     * 로그인 검증
     */
    @Override
    public void validate(Object target, Errors errors) {
        /**
         * 1. 아이디로 회원 조회
         * 2. 조회된 회원의 비밀번호와 입력한 비밀번호의 일치 여부
         */
        RequestLogin form = (RequestLogin) target ;
        String userId = form.userId() ;
        String userPw = form.userPw() ;

        // 아이디로 회원 조회
        Member member = memberDao.get(userId) ;
        if (member == null) {
            errors.reject("Login.auth.fail");
        }

        // 조회된 회원의 비밀번호와 입력한 비밀번호의 일치 여부
        if (member != null && StringUtils.hasText(userPw)
            && !BCrypt.checkpw(userPw, member.getUserPw())) {   // 비밀번호 해시값으로 검증
            errors.reject("Login.auth.fail");
        }
    }
}
