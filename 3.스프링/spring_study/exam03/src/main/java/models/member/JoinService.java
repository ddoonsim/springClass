package models.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

// JoinService(회원가입) 기능을 완성하기 위해 다른 객체를 조립해야 함 --> 의존성의 개념 확인 가능
public class JoinService {

    @Autowired    // 스프링에게 의존성 주입을 지시하는 어노테이션
    @Qualifier("memberDao")
    private MemberDao memberDao ;
    @Autowired
    private JoinValidator validator ;

    public  JoinService() {}

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
