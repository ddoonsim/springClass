package mapper;

import models.member.Member;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 인터페이스만 정의하면 스프링이 구현체를 자동으로 생성
 */
public interface MemberMapper {

    //@Select("SELECT * FROM MEMBER ORDER BY USER_NO")    <-- xml 파일에 메서드 명과 같은 mapper가 정의 되어 있으면 어노테이션 없어도 됨
    List<Member> getMembers() ;

    //@Insert("INSERT INTO MEMBER (USER_NO, USER_ID, USER_PW, USER_NM) " +
    //        "VALUES (SEQ_MEMBER.nextval, #{userId}, #{userPw}, #{userNm})")
    int register(Member member) ;

    int update(Member member) ;

    int delete(String userId) ;
}
