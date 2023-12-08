package exam01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Ex01 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("oracle.jdbc.driver.OracleDriver") ;    // 동적 로딩

        String url = "jdbc:oracle:thin:@localhost:1521:orcl" ;
        String username = "SPRING6" ;
        String password = "_aA123456";

        Connection conn = null ;

        try {
            conn = DriverManager.getConnection(url, username, password);
            System.out.println(conn);
        } catch (SQLException e) {
            System.out.println("⚠️DB연결 중 예외 발생");
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println("⚠️자원 해제 중 예외 발생");
                e.printStackTrace();
            }
        }
    }
}
