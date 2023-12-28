package models.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListService {

    private MemberDao memberDao ;

    @Autowired    // 생성자에 @Autowired 입력하는 경우 ==> 생성할 때 객체가 주입된다는 차이점
    public void setMemberDao(MemberDao memberDao) {
        this.memberDao = memberDao ;
    }
    public void print() {
        List<Member> members = memberDao.getList() ;

        for (Member member : members) {
            System.out.println(member);
        }
    }
}
