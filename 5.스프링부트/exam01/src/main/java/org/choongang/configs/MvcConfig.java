package org.choongang.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Mvc 설정 클래스
 */
@Configuration
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
