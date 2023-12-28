package main;

import config.AppCtx;
import models.member.JoinService;
import models.member.ListService;
import models.member.Member;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDateTime;

public class Ex01 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class) ;

        JoinService joinService = ctx.getBean("joinService", JoinService.class) ;    // 회원가입 기능 호출
        ListService listService = ctx.getBean(ListService.class) ;    // 회원 목록 조회 기능 호출

        // 회원 정보 입력
        Member member = new Member() ;
        member.setUserId("user01");
        member.setUserPw("123456");
        member.setConfirmPw("123456");
        member.setUserNm("사용자01");
        member.setRegDt(LocalDateTime.now());

        joinService.join(member);    // 회원가입
        listService.print();         // 회원 목록 출력

        ctx.close();
    }
}
