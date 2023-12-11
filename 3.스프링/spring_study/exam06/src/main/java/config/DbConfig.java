package config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@MapperScan("mapper")    // mapper 자동 스캔
public class DbConfig {

    @Bean(destroyMethod = "close")  // 자원 해제 자동화
    public DataSource dataSource() {
        DataSource ds = new DataSource() ;
        // 데이터 소스 DB 설정
        ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        ds.setUrl("jdbc:oracle:thin:@localhost:1521:orcl");
        ds.setUsername("SPRING6");
        ds.setPassword("_aA123456");

        // 커넥션 풀 설정
        ds.setInitialSize(2);
        ds.setTestWhileIdle(true);  // 유휴 상태 커넥션 객체를 체크 여부
        ds.setTimeBetweenEvictionRunsMillis(3000);  // 3초마다 커넥션 상태 체크
        ds.setMinEvictableIdleTimeMillis(30 * 1000);  // 30초가 최대 유휴 시간 --> 경과 시 소멸

        return ds ;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource()) ;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sessionFactoryBean = new SqlSessionFactoryBean() ;
        sessionFactoryBean.setDataSource(dataSource());    // myBatis 자동 세팅

        return sessionFactoryBean.getObject() ;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        DataSourceTransactionManager tm = new DataSourceTransactionManager(dataSource()) ;
        return tm ;
    }
}
