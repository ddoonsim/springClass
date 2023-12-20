package controllers.member;

import controllers.admin.MemberSearch;
import lombok.RequiredArgsConstructor;
import mapper.MemberMapper;
import models.member.Member;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberDao {

    private final MemberMapper mapper ;

    /**
     * 회원 가입 메서드
     * @return true => 회원 가입 성공
     */
    public boolean register(Member member) {
        int affectedRows = mapper.register(member);

        return affectedRows > 0 ;
    }

    /**
     * 아이디 중복 여부
     * @return true => 이미 존재하는 아이디
     */
    public boolean exist(String userId) {
        int cnt = mapper.exist(userId);

        return cnt > 0 ;
    }

    /**
     * 아이디로 회원 검색
     * @return Member 객체
     */
    public Member get(String userId) {
        return mapper.get(userId) ;
    }

    public List<Member> getList(MemberSearch search) {
        return mapper.getList(search) ;
    }
}
