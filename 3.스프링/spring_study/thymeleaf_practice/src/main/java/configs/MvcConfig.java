package configs;

import commons.Utils;
import nz.net.ultraq.thymeleaf.layoutdialect.LayoutDialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.*;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;

@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {

    @Autowired
    private ApplicationContext applicationContext ;

    @Bean
    public MemberOnlyInterceptor memberOnlyInterceptor() {
        return new MemberOnlyInterceptor() ;
    }

    @Bean
    public CommonInterceptor commonInterceptor() {
        return new CommonInterceptor() ;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(memberOnlyInterceptor())
                .addPathPatterns("/mypage/**") ;

        registry.addInterceptor(commonInterceptor())
                .addPathPatterns("/**") ;
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();  // DefaultServletHttpRequestHandler, SimpleUrlHandlerMapping 빈 객체를 추가
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/") ;
        // 모든 요청 -> 컨트롤러 빈
        // 없는 경우 => 정적 자원 경로(css, js, 이미지)  ## 정적 자원은 보통 resources 하위에 저장함
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/")
                .setViewName("main/index") ;
    }

    @Bean    // ViewResolver를 설정
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(applicationContext);
        templateResolver.setPrefix("/WEB-INF/templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setCacheable(false);
        // true => 최초 서버 로딩 시 번역, 다음 요청 시에는 기존 파일을 그대로 사용
        // false => 매번 요청 시마다 다시 번역 (개발 중)
        return templateResolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        templateEngine.setEnableSpringELCompiler(true);  // EL식 활용 가능하게 설정
        templateEngine.addDialect(new Java8TimeDialect());  // 확장 기능 : Date Time API(java.time패키지) - #temporals
        templateEngine.addDialect(new LayoutDialect());     // 확장 기능 : 레이아웃 기능 추가
        return templateEngine;
    }

    @Bean
    public ThymeleafViewResolver thymeleafViewResolver() {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setContentType("text/html");    // 페이지의 contentType 설정
        resolver.setCharacterEncoding("utf-8");  // 페이지의 인코딩 설정
        resolver.setTemplateEngine(templateEngine());
        return resolver;
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.viewResolver(thymeleafViewResolver());
    }

    @Bean
    public MessageSource messageSource() {  // 메서드 이름 동일하게 설정!!
        ResourceBundleMessageSource ms = new ResourceBundleMessageSource() ;
        ms.setDefaultEncoding("UTF-8");
        ms.setBasenames("messages.commons", "messages.validations");

        return ms ;
    }

    @Bean
    public Utils utils() {
        return new Utils() ;
}
}
