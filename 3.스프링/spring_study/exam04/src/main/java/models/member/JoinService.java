package models.member;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

// JoinService(회원가입) 기능을 완성하기 위해 다른 객체를 조립해야 함 --> 의존성의 개념 확인 가능
@Service    // 스프링에 자동 추가인 경우 빈의 이름
            // : 클래스명에서 첫 알파벳만 소문자로 바꾼 형태 --> joinService
@RequiredArgsConstructor    // 초기화가 반드시 필요한 멤버 변수를 생성자 매개 변수로 자동 생성
public class JoinService {

    // 초기화가 반드시 필요한 멤버 변수 : 상수 | @NonNull
    private final MemberDao memberDao ;
    @NonNull
    private JoinValidator validator ;

    public void join(Member member) {
        // 데이터 검증
        validator.validate(member);

        // 데이터 추가
        memberDao.register(member);
    }
}
