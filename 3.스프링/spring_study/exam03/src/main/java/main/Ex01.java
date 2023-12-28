package main;

import config.AppCtx;
import config.AppCtx2;
import config.AppCtx3;
import config.AppCtx4;
import models.member.JoinService;
import models.member.ListService;
import models.member.Member;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDateTime;

public class Ex01 {
    public static void main(String[] args) {
        // 스프링 컨테이너 객체 생성
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx4.class) ;

        // 스프링이 관리할 (싱글톤)클래스 호출
        JoinService joinService = ctx.getBean("joinService", JoinService.class) ;
        ListService listService = ctx.getBean(ListService.class) ;
            // 스프링 컨테이너에 유일한 객체라서 헷갈리지 않는다면 이름을 명시하지 않아도 OK

        Member member = new Member() ;
        member.setUserId("user01");
        member.setUserPw("123456");
        member.setConfirmPw("123456");
        member.setUserNm("사용자01");
        member.setRegDt(LocalDateTime.now());

        joinService.join(member);

        listService.print();

        ctx.close();    // 컨테이너 닫기
    }
}
