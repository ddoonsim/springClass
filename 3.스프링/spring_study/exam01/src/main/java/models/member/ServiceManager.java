package models.member;

import java.util.List;

/**
 * 의존성을 조립해서 하나의 기능으로 완성하는 클래스
 */
public class ServiceManager {

    /**
     * 객체를 조립하기 위한 구성 요소인 MemberDao
     * @return
     */
    public MemberDao memberDao() {
        return new MemberDao() ;
    }

    /**
     * 객체를 조립하기 위한 구성 요소인 JoinValidator
     * @return
     */
    public JoinValidator joinValidator() {
        return new JoinValidator(memberDao()) ;
    }

    /**
     * 필요한 부품을 조립하여 JoinService 기능 완성
     * @return
     */
    public JoinService joinService() {
        return new JoinService(memberDao(), joinValidator()) ;
    }

    /**
     * 조립하여 회원 목록 조회 기능을 완성
     * @return
     */
    public ListService listService() {
        ListService listService = new ListService() ;
        listService.setMemberDao(memberDao());

        return listService ;
    }
}
