package exam03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex02 {
    public static void main(String[] args) throws IOException {
        System.out.print("아무거나 입력 : ");
//        char ch = (char) System.in.read() ;
        InputStreamReader isr = new InputStreamReader(System.in) ;    // 바이트 단위 --> 문자 변환
        BufferedReader br = new BufferedReader(isr) ;    // 성능 향상을 위한 보조 스트림
        char ch = (char) br.read() ;
        System.out.println(ch);
    }
}
