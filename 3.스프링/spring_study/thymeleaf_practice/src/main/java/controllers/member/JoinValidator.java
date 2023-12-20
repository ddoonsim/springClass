package controllers.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class JoinValidator implements Validator {

    private final MemberDao memberDao ;

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(RequestJoin.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        RequestJoin form = (RequestJoin) target ;

        // 중복 아이디 여부 체크
        String userId = form.getUserId() ;
        if (StringUtils.hasText(userId) && memberDao.exist(userId)) {
            // 이미 가입된 아이디 ==> 가입 X
            errors.rejectValue("userId", "Duplicated");
        }

        // 비번과 비번확인 일치 여부 체크
        String userPw = form.getUserPw() ;
        String confirmPw = form.getConfirmPw() ;
        if (StringUtils.hasText(userPw) && StringUtils.hasText(confirmPw)
                && !userPw.equals(confirmPw)) {
            errors.rejectValue("confirmPw", "Mismatch");
        }
    }
}
