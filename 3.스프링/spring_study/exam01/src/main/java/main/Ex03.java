package main;

import java.util.Arrays;

public class Ex03 {
    public static void main(String[] args) {
        int res = add(10, 20, 30, 40, 50) ;
        System.out.println(res);
    }

    public static int add(int num1, int num2) {
        return num1 + num2 ;
    }
    // 다른 함수(함수의 시그니처가 다른 함수)를 오버로딩
        // 완전히 같은 메서드를 정의하는 경우 컴파일 오류 발생
    public static int add(int num1, int num2, int num3) {
        return num1 + num2 + num3 ;
    }

    /**
     * ... : 개수가 가변적인 매개 변수
     */
    public static int add(int ... nums) {
        /*int total = 0 ;
        for (int num : nums) {
            total += num ;
        }*/
        int total = Arrays.stream(nums).sum() ;    // 스트림 이용
        return total ;
    }
}
