package models.member;

// JoinService(회원가입) 기능을 완성하기 위해 다른 객체를 조립해야 함 --> 의존성의 개념 확인 가능
public class JoinService {

    private MemberDao memberDao ;
    private JoinValidator validator ;

    public JoinService(MemberDao memberDao, JoinValidator validator) {
        this.memberDao = memberDao ;
        this.validator = validator ;
    }

    public void join(Member member) {
        // 데이터 검증
        validator.validate(member);

        // 데이터 추가
        memberDao.register(member);
    }
}
