package models.member;

import commons.exceptions.BadRequestException;
import commons.validators.RequiredValidator;
import commons.validators.Validator;

public class JoinValidator implements Validator<Member>, RequiredValidator {

    // MemberDao의 기능 중 일부를 가져오고 싶을 때 필드에 선언하고 생성자로 초기화
    private MemberDao memberDao ;

    // 외부에서 데이터를 주입해주는 의존성 : 통제가 용이하다는 장점이 있음
    public JoinValidator(MemberDao memberDao) {
        this.memberDao = memberDao ;
    }

    public void validate(Member member) {
        /* 필수 항목 검증(아이디, 비밀번호, 비밀번호 확인, 회원명) */
        String userId = member.getUserId();
        String userPw = member.getUserPw();
        String confirmPw = member.getConfirmPw();
        String userNm = member.getUserNm();

        // 필수 항목은 null 또는 빈 공백 문자("  ") 체크
        // RuntimeException e = new BadRequestException("str") ;
        checkRequired(userId, new BadRequestException("아이디를 입력하세요."));
        checkRequired(userPw, new BadRequestException("비밀번호를 입력하세요."));
        checkRequired(confirmPw, new BadRequestException("비밀번호 확인을 하세요."));
        checkRequired(userNm, new BadRequestException("회원명을 입력하세요."));

        // 아이디가 이미 등록되어 있는지 체크
        // 체크기능을 완성하기 위해 MemberDao의 객체가 필요 --> 의존성
        checkFalse(memberDao.exists(userId), new BadRequestException("이미 등록된 아이디입니다."));

        // 비밀번호, 비밀번호 확인 시 일치 여부 체크
        checkTrue(userPw.equals(confirmPw), new RuntimeException("비밀번호가 일치하지 않습니다."));
    }
}
