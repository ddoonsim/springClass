package config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

import java.util.HashMap;
import java.util.Map;

@Aspect
@Order(1)
public class ProxyCache {

    private Map<Long, Object> cacheData = new HashMap<>() ;

    @Around("config.CommonPointcut.publicTarget()")  // 범위에 대한 Ant 경로 패턴을 직접 입력 가능!
    //리턴 타입, 매개 변수 타입, 예외 전가 고정
    public Object process(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();  // 매개 변수로 투입된 인자 값 조회( ex) 10 )
        Long num = (Long)args[0] ;
        if(cacheData.containsKey(num)) {  // 캐시가 있으면 캐시값 리턴
            System.out.println("캐시 있음 ==> 캐시값 사용!");
            return cacheData.get(num) ;
        }
        Object result = joinPoint.proceed() ;

        // 캐시 없으면 저장
        cacheData.put(num, result) ;
        System.out.println("캐시 없음 ==> 캐시 저장!");

        return result ;
    }
}
