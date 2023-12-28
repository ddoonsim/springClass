package controllers.member;

import lombok.RequiredArgsConstructor;
import models.member.MemberDao;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * 유효성 검사 클래스
 */
@Component   // 자동 스캔 범위 내에 있기 때문에 Component 어노테이션으로 스캔 대상으로 등록
@RequiredArgsConstructor
public class JoinValidator implements Validator {

    private final MemberDao memberDao ;

    /**
     * 검증하고자 하는 객체를 커맨드 객체로 제한하는 메서드
     */
    @Override
    public boolean supports(Class<?> clazz) {   // 검증 커맨드 객체를 제한
        return clazz.isAssignableFrom(RequestJoin.class);
    }

    /**
     * 실제로 검증을 수행할 메서드
     * @param target the object that is to be validated : 검증할 커맨드 객체
     * @param errors contextual state about the validation process : 검증 실패시 에러 정보 처리
     */
    @Override
    public void validate(Object target, Errors errors) {
        /**
         * 1. 필수 항목 검증(userId, userPw, confirmPw, userNm, agree)
         * 2. 중복 아이디 여부 검사  <-- 이 부분만 코드를 구성하면 됨, 나머지는 어노테이션으로 해결
         * 3. 아이디 최소 자리수 6자리 이상
         * 4. 비밀번호 최소 자리수 8자리 이상
         * 5. 비밀번호 일치 확인     <-- 이 부분만 코드를 구성하면 됨, 나머지는 어노테이션으로 해결
         * 6. 이메일 값은 필수는 아니지만 값이 있으면 형식 체크
         */

        RequestJoin form = (RequestJoin) target ;  // 커맨드 객체로 형변환

        // 중복 아이디 여부 체크
        String userId = form.getUserId() ;
        if (StringUtils.hasText(userId) && memberDao.exist(userId)) {
            // 이미 가입된 아이디 --> 가입 X
            errors.rejectValue("userId", "Duplicated");
        }

        // 비번과 비번 확인 일치 여부 체크
        String userPw = form.getUserPw() ;
        String confirmPw = form.getConfirmPw() ;
        if (StringUtils.hasText(userPw) && StringUtils.hasText(confirmPw)
                && !userPw.equals(confirmPw)) {
            errors.rejectValue("confirmPw", "Mismatch");
        }

        /*
        boolean result = false ;
        if(!result) {
            errors.reject("errorTest", "공통 에러!");
        }
         */
    }
}
