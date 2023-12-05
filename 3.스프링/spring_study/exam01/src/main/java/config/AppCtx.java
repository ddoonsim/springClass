package config;

import models.Greeter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration    // 설정 클래스임을 스프링 컨테이너에 알려 주는 annotation
public class AppCtx {

    @Bean    // 스프링이 관리해야 할 객체임을 알려 주는 annotation
    public Greeter greeter() {
        return new Greeter() ;
    }
}
