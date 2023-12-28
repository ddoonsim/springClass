package exam03;

import java.util.Scanner;

public class Ex03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in) ;    // 문자 단위, 버퍼 기능 탑재
        System.out.print("아무거나 입력 > ") ;
        String str = sc.nextLine() ;
        System.out.println(str);
    }
}
