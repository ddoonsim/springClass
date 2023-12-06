package models.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.lang.Nullable;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class ListService {

    private MemberDao memberDao ;
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy.MM.dd") ;

    @Autowired
    public void setMemberDao(@Qualifier("memberDao") MemberDao memberDao) {
        this.memberDao = memberDao ;
    }

    // @Autowired(required = false)    // --> 스프링 컨테이너에 담지 않음
    @Autowired
    public void setFormatter(DateTimeFormatter formatter) {
        this.formatter = formatter ;
    }

    public void print() {
        List<Member> members = memberDao.getList() ;

        for (Member member : members) {
            if (formatter != null) {    // --> NPE 처리
                String regDtStr = formatter.format(member.getRegDt());
                member.setRegDtStr(regDtStr);
            }
            System.out.println(member);
        }
    }
}
