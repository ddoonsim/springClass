package models.member.sub;

import org.springframework.stereotype.Repository;

// @Repository    // 빈의 이름 : memberDao --> member.MemberDao와 이름이 같음
                  // ==> 이름 충돌이 발생해서 예외 발생
@Repository("memberDao2")    // --> 빈의 이름을 직접 설정
public class MemberDao {
}
