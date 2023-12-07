package commons.validators;

import org.springframework.util.StringUtils;

/**
 * 필수 항목 유효성(값 입력 필수) 체크
 */
public interface RequiredValidator {

    /**
     * 인스턴스 메서드
     * 필수항목에 대한 null 또는 공백 체크 메서드
     * @param str
     * @param e
     */
    default void checkRequired(String str, RuntimeException e) {
        if(!StringUtils.hasText(str)) {    // 스프링에 내장되어 있는 편의기능(StringUtils) 사용
            throw e ;
        }
    }

    /**
     * 비밀번호 확인이 일치하지 않을 때 예외 발생
     * @param result
     * @param e
     */
    default void checkTrue(boolean result, RuntimeException e) {
        if (!result) {
            throw e ;
        }
    }

    /**
     * 아이디가 존재하면(result가 참이면) 예외 발생
     */
    default void checkFalse(boolean result, RuntimeException e) {
        if(result) {
            throw e ;
        }
    }
}
