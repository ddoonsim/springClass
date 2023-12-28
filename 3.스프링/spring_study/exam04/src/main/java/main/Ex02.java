package main;

import config.AppCtx2;
import models.Message;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Ex02 {
    public static void main(String[] args) {
        // 객체 생성 -> 의존 설정 -> 초기화(afterPropertiesSet) 수행
        AnnotationConfigApplicationContext ctx =
                new AnnotationConfigApplicationContext(AppCtx2.class) ;

        Message m1 = ctx.getBean(Message.class) ;
        Message m2 = ctx.getBean(Message.class) ;
        System.out.println(m1 == m2);    // 싱글톤 객체라서 동일 객체를 참조

        // 컨테이너 소멸
        ctx.close();    // 컨테이너 소멸 전에 destroy() 메서드 호출
    }
}
