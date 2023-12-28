package main;

import aopex.* ;
import config.AppCtx;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Ex01 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class) ;

        Calculator cal = ctx.getBean(Calculator.class) ;  // Proxy 객체
        // 실행 순서 : ProxyCache -> ProxyCalculator(빈이 등록된 순서에 따라, but 순서 고정 X)
        // 프록시를 이용해서 캐시에 동일한 값이 존재하는지 확인 : ProxyCache
        // 없으면 factorial() 메서드 실행 : ProxyCalculaotr
        long result = cal.factorial(10L) ;
        System.out.printf("cal : %d%n", result);

        // 동일한 동작, 동일한 결과값을 내는 작업
        // ==> 프록시를 이용해서 캐시에 동일한 값이 존재하는지 확인 : ProxyCache
        // ==> 성능 저하를 막을 수 있음
        long result2 = cal.factorial(10L) ;
        System.out.printf("cal : %d%n", result2);

        long result3 = cal.factorial(10L) ;
        System.out.printf("cal : %d%n", result3);

        long result4 = cal.factorial(10L) ;
        System.out.printf("cal : %d%n", result4);

        ctx.close();
    }
}
