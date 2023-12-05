package commons.validators;

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
        if(str == null || str.isBlank()) {
            throw e ;
        }
    }
}
