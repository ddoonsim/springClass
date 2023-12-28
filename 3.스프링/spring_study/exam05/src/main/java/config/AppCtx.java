package config;

import aopex.*;
import config.* ;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)   // 설정 자동화 annotation
    // proxyTargetClass = true이면 클래스 기반의 프록시 생성 가능
public class AppCtx {

    // 스프링 관리 객체로 등록
    @Bean
    public RecCalculator calculator() {
        return new RecCalculator() ;
    }

    @Bean    // 먼저 실행
    public ProxyCache proxyCache() {
        return new ProxyCache() ;
    }

    @Bean    // proxyCache() 다음에 실행
    public ProxyCalculator proxyCalculator() {
        return new ProxyCalculator() ;
    }
}
