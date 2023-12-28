package main;

import config.AppCtx;
import models.Greeter;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Ex01 {
    public static void main(String[] args) {
        // AnnotationConfig : 객체 관리를 annotation 설정 방식으로 스프링 컨테이너에 담으라고 지시
        // ApplicationContext : 스프링 컨테이너를 가리킴
        // ==> AnnotationConfigApplicationContext : annotation을 이용하여 클래스로부터 객체 설정 정보를 가져옴
        // 매개변수 : 스프링 컨테이너가 관리해야 할 설정 클래스(.class)
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class) ;

        Greeter g1 = ctx.getBean("greeter", Greeter.class) ;    // class : 클래스에 대한 정보가 담겨 있는 객체
        g1.hello("이름");

        Greeter g2 = ctx.getBean("greeter", Greeter.class) ;
        System.out.println(g1 == g2);

        ctx.close();
    }
}
