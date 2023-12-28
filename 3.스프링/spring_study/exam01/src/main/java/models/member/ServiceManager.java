package models.member;

/**
 * 의존성을 조립해서 하나의 기능으로 완성하는 클래스
 * ==> 완성된 기능을 수행하는 객체는 하나만 생성하고 공유 --> 싱글톤으로 만듦
 */
public class ServiceManager {

    private static ServiceManager instance = null ;

    private ServiceManager() {}

    public static ServiceManager getInstance() {
        // 필요할 때만 객체 생성하기 위해
        if(instance == null) {
            instance = new ServiceManager() ;
        }
        return instance ;
    }

    /**
     * 객체를 조립하기 위한 구성 요소인 MemberDao
     * @return
     */
    public MemberDao memberDao() {
        return new CachedMemberDao() ;    // 기능을 확장한 클래스로 개선하기에 용이
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
