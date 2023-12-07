package config;

import models.member.MemberDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
/*@ComponentScan(value="models",    // 스캔 범위 설정 --> models 하위 객체 전부 스캔
                // 자동 스캔 범위에서 배제하는 속성 설정
                excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,
                                                        classes = ManualBean.class))*/
/*@ComponentScan(value = "models",
                excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, // 메서드 배제 지정
                                                        classes = {MemberDao.class}))*/
@ComponentScan(value = "models",
                excludeFilters = @ComponentScan.Filter(
                        type = FilterType.ASPECTJ, pattern = "models..*Dao"    // 패턴에 맞는 객체를 배제
                ))
public class AppCtx {

    /*
    @Bean    // 이름이 동일한 경우, 수동 등록 빈이 자동 등록 빈보다 우선 선택됨
    public MemberDao memberDao() {
        System.out.println("수동 등록 빈");
        return new MemberDao() ;
    }
     */
}
