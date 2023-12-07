package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("models")    // 스캔 범위 설정 가능 --> models 하위의 모든 패키지를 범위로 설정
public class AppCtx4 {
}
