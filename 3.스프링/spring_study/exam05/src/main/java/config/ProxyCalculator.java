package config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

@Aspect    // AOP로 인식
@Order(2)
public class ProxyCalculator {

    /*
    @Pointcut("execution(long aopex..*(long))")  // aopex의 모든 클래스의 모든 메서드에 적용 명시
        // * : 모든 반환값
    public void publicTarget() {}
    */

    //@Around("publicTarget()")
    //@Around("execution(* aopex..*(..))")
    @Around("config.CommonPointcut.publicTarget()")
    //@Around("CommonPointcut.publicTarget()")    // 같은 패키지인 경우에는 패키지 명 생략 가능
        // 간단한 로직인 경우 Pointcut 어노테이션 없이 Around 어노테이션에 경로 직접 명시
    public Object process(ProceedingJoinPoint joinPoint) throws Throwable {
        //Signature sig = joinPoint.getSignature() ;
        //System.out.println(sig.toLongString());  // 현재 호출하고 있는 프록시의 메서드 정보
        //Object[] args = joinPoint.getArgs();    // 메서드 사용 시에 매개 변수에 대입한 정보 조회
        //long num = (Long)args[0] ;
        //System.out.println(num);

        long stime = System.nanoTime();    // 공통 기능
        try {
            Object result = joinPoint.proceed();   // 핵심 기능을 대신 수행하는 메서드
                    // factorial(...)
            return result;
        } finally {
            long etime = System.nanoTime() ;    // 공통 기능
            System.out.printf("걸린 시간 : %d%n", etime - stime);
        }
    }
}
