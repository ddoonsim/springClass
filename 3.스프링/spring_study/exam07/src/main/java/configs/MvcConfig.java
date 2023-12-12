package configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
    // 프록시 형태로 필요한 HandlerMapping, HandlerAdapter, ViewResolver 객체를
    // 자동으로 스프링 컨테이너에 포함시킴
    // 따라서, @Bean 어노테이션으로 스프링 컨테이너에 각각 등록시킬 필요 X
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();  // DefaultServletHttpRequestHandler, SimpleUrlHandlerMapping 빈 객체를 추가
    }

    /**
     * view 객체를 찾는 메서드, 경로 설정 필요
     * @param registry
     */
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/templates/", ".jsp") ;  // view가 있는 디렉토리 경로
    }
}
