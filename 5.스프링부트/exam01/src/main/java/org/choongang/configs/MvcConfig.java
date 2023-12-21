package org.choongang.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Mvc 설정 클래스
 */
@Configuration
@EnableScheduling    // 정기적으로 하는 작업을 예약하기 위한 설정 코드 프록시 형태로 자동 추가
@EnableConfigurationProperties(FileProperties.class)    // FileProperties 클래스 주입
//@EnableWebMvc : 필요 없음
public class MvcConfig implements WebMvcConfigurer {

    @Autowired
    private FileProperties fileProperties ;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(fileProperties.getUrl() + "**")
                .addResourceLocations("file:///" + fileProperties.getPath()) ;
    }
}
