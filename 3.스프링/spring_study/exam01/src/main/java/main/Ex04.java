package main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Ex04 {
    public static void main(String[] args) throws FileNotFoundException {
        // 컴파일 시 체크되는 예외 -> 예외처리가 없으면 컴파일 실행 X
        FileInputStream fis = new FileInputStream("abc.txt") ;
    }
}
