package controllers.member;

/**
 * 레코드 클래스
 */
public record RequestLogin(
        String userId,
        String userPw
) {
}
