package config;

import aopex.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppCtx {

    @Bean
    public Calculator calculator() {
        return new RecCalculator() ;
    }
}
