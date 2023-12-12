package configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

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
     * 정적 자원의 경로 설정
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/") ;
        // 모든 요청 -> 컨트롤러 빈
        // 없는 경우 => 정적 자원 경로(css, js, 이미지)  ## 정적 자원은 보통 resources 하위에 저장함
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
