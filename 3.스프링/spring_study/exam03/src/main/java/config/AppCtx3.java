package config;

import models.member.MemberDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.time.format.DateTimeFormatter;

@Configuration
public class AppCtx3 {

    @Bean
    //@Primary
    public MemberDao memberDao() {
        return new MemberDao() ;
    }

    /*@Bean
    // 이름이 다른 객체가 스프링 컨테이너 안에 존재하면 오류 --> 어떤 객체인지 명시해서 해결
    // 스프링 컨테이너 안에 일치하는 빈이 여러 개 있을 경우 -> 예외 발생
        // 해결 방법 : 1) 순서를 정한다. @Primary : 동일한 자료형의 빈이 있는 경우 가장 우선순위 명시
                    // 2) 적용할 빈의 이름을 한정 @Qualifier
    public MemberDao memberDao2() {
        return new MemberDao() ;
    }*/

    @Bean
    public DateTimeFormatter formatter() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm") ;
        return formatter ;
    }

}
