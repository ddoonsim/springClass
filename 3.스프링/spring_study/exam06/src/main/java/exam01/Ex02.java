package exam01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex02 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver") ;
        String url = "jdbc:oracle:thin:@localhost:1521:orcl" ;
        String username = "SPRING6" ;
        String password = "_aA123456" ;

        // 연결 객체, 자동 자원 해제 만들기
        try(Connection conn = DriverManager.getConnection(url, username, password);
            Statement stmt = conn.createStatement()) {

            String sql = "INSERT INTO MEMBER (USER_NO, USER_ID, USER_PW, USER_NM, EMAIL) " +
                            "VALUES (SEQ_MEMBER.nextval, 'USER01', '123456', '사용자01', 'user01@test.org')" ;
            int result = stmt.executeUpdate(sql) ;
            System.out.println(result + "건 데이터 추가");
        }
        catch (SQLException e) {
            System.out.println("⚠️DB 연결 중 예외 발생");
            e.printStackTrace();
        }
    }
}
