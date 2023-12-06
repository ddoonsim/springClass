package main;

import models.member.*;

import java.time.LocalDateTime;

public class Ex06 {
    public static void main(String[] args) {
        // 회원가입
        MemberDao memberDao = new MemberDao() ;
        JoinValidator joinValidator = new JoinValidator(memberDao) ;
        JoinService joinService = new JoinService(memberDao, joinValidator) ;

        // 회원 목록 출력
        ListService listService = new ListService() ;
        listService.setMemberDao(memberDao);

        Member member = new Member() ;
        member.setUserId("user01");
        member.setUserPw("123456");
        member.setConfirmPw("123456");
        member.setUserNm("사용자01");
        member.setRegDt(LocalDateTime.now());
    }
}
