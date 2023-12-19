package controllers.member;

import jakarta.validation.constraints.NotBlank;

/**
 * 레코드 클래스
 */
public record RequestLogin(
        @NotBlank
        String userId,
        @NotBlank
        String userPw
) {}
