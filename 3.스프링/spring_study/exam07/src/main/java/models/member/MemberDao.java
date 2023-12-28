package models.member;

import controllers.admin.MemberSearch;
import lombok.RequiredArgsConstructor;
import mapper.MemberMapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberDao {

    private final MemberMapper mapper ;

    public boolean register(Member member) {
        int affectiedRows = mapper.register(member) ;

        return affectiedRows > 0 ;    // 1 이상 ==> 등록 OK
    }

    public boolean exist(String userId) {
        int cnt = mapper.exist(userId);

        return cnt > 0 ;    // 1 이상 ==> 이미 등록된 아이디
    }

    public Member get(String userId) {
        return mapper.get(userId) ;
    }

    public List<Member> getList(MemberSearch search) {
        LocalDate edate = search.getEdate() ;
        if (edate != null) {
            LocalDate newEdate = edate.plusDays(1);
            search.setEdate(newEdate);
        }

        return mapper.getList(search) ;
    }
}
