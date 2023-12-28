package models.member;

import controllers.member.RequestJoin;
import lombok.RequiredArgsConstructor;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JoinService {
    private final MemberDao memberDao;

    public void join(RequestJoin form) {

        // 비밀번호 암호화(BCrypt 이용)
        String hash = BCrypt.hashpw(form.getUserPw(), BCrypt.gensalt(12)) ;

        Member member = Member.builder()
                .userId(form.getUserId())
                .userPw(hash)
                .userNm(form.getUserNm())
                .email(form.getEmail())
                .build();

        memberDao.register(member);
    }
}