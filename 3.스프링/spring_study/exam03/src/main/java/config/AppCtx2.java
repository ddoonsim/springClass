package config;

import models.member.JoinService;
import models.member.JoinValidator;
import models.member.ListService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(AppCtx3.class)
public class AppCtx2 {

    @Bean
    public JoinValidator joinValidator() {
        return new JoinValidator() ;    // 의존성 조립이 X --> 조립을 스프링에 맡김
    }

    @Bean
    public JoinService joinService() {
        return new JoinService() ;    // 의존성 조립이 X --> 조립을 스프링에 맡김
    }

    @Bean
    public ListService listService() {
        return new ListService() ;    // 의존성 조립이 X --> 조립을 스프링에 맡김
    }
}
