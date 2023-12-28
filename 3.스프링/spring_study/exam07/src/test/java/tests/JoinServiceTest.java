package tests;

import configs.ControllerConfig;
import configs.DbConfig;
import configs.MvcConfig;
import controllers.member.RequestJoin;
import models.member.JoinService;
import models.member.Member;
import models.member.MemberDao;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import java.sql.Connection;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;


//@WebAppConfiguration
@Transactional    // test 완료 후 rollback 수행하여 db에 저장 X
@SpringJUnitWebConfig
@ContextConfiguration(classes = {MvcConfig.class, ControllerConfig.class})
public class JoinServiceTest {

    @Autowired
    private WebApplicationContext ctx ;    // web 컨테이너 의존성 추가
    private MockMvc mockMvc ;     // 통합테스트할 때 : MockMvc
    @Autowired
    private DataSource dataSource;
    @Autowired
    private MemberDao memberDao;
    @Autowired
    private JoinService joinService ;
    @BeforeEach    // 개별 테스트 전에 수행
    void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build() ;
    }

    @Test
    @DisplayName("데이터베이스 연결 테스트")
    void connectionTest() {
        try (Connection conn = dataSource.getConnection()) {
            System.out.println(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("MemberDao - exist 메서드 테스트")
    void existsTest() {
        String userId = "USER01";
        boolean result = memberDao.exist(userId);

        assertTrue(result);
    }

    @Test
    @DisplayName("JoinServiec - join메서드 테스트")
    void joinTest() {
        RequestJoin form = new RequestJoin() ;
        form.setUserId("user01");
        form.setUserPw("12345678");
        form.setUserNm("사용자01");
        form.setEmail("user01@test.org");

        joinService.join(form);

        Member member = memberDao.get(form.getUserId()) ;

        System.out.println(member);
    }

    @Test
    @DisplayName("회원가입 통합 테스트")
    void joinTest2() throws Exception {
        mockMvc.perform(post("/member/join")
                .param("userId", "user01"))
                .andDo(print());
    }
}