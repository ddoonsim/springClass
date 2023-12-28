package main;

import models.member.*;

import java.time.LocalDateTime;

public class Ex06 {
    public static void main(String[] args) {
        // 객체 조립한 기능 완성 객체 ServiceManager 싱글톤 객체 사용하여 코드 단순화 & 유지와 보수에 용이
        JoinService joinService = ServiceManager.getInstance().joinService() ;
        ListService listService = ServiceManager.getInstance().listService() ;

        Member member = new Member() ;
        member.setUserId("user01");
        member.setUserPw("123456");
        member.setConfirmPw("123456");
        member.setUserNm("사용자01");
        member.setRegDt(LocalDateTime.now());

        joinService.join(member);

        listService.print();
    }
}
