package tests;

import configs.DbConfig;
import configs.MvcConfig;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.sql.Connection;

@SpringJUnitConfig  // 통합 테스트, @ExtendWith 포함되어 있기 때문에 따로 설정 필요 X
@ContextConfiguration(classes = DbConfig.class)
public class JoinServiceTest {

    @Autowired
    private DataSource dataSource ;

    @Test
    @DisplayName("데이터베이스 연결 테스트")
    void connectionTest() {
        try(Connection conn = dataSource.getConnection()) {
            System.out.println(conn);
        }
        catch (Exception e) {
            System.out.println("DB 연결 테스트 중 예외 발생");
            e.printStackTrace();
        }
    }
}
