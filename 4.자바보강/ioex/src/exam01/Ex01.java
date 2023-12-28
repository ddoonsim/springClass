package exam01;

import java.io.FileInputStream;
import java.io.IOException;

public class Ex01 {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("test1.txt")) {
            /*char ch = (char) fis.read() ;    // 1바이트 읽기
            System.out.println(ch);*/

            int ch = 0 ;
            while ((ch = fis.read()) != -1) {
                System.out.print((char)ch);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
