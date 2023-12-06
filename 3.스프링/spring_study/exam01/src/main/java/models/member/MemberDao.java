package models.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberDao {
    private static Map<String, Member> members = new HashMap<>() ;

    public void register(Member member) {
        members.put(member.getUserId(), member) ;
    }

    /**
     * 회원 아이디가 이미 존재하는 지 여부를 확인하는 메서드
     * @param userId
     * @return 이미 존재 하면 true, 없으면 false
     */
    public boolean exists(String userId) {
        return members.containsKey(userId) ;
    }

    /**
     * 회원 목록을 반환하는 메서드
     */
    public List<Member> getList() {
        return new ArrayList<>(members.values()) ;
    }
}
