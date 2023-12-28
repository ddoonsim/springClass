package config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Pointcut만 따로 관리라는 클래스
 */
@Aspect
public class CommonPointcut {

    @Pointcut("execution(* aopex..*(long))")
    public void publicTarget() {}  // 프록시 범위에 대한 정보를 전달하는 역할만 하는 빈 메서드

}
