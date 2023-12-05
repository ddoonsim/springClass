package main;

public class Ex05 {
    public static void main(String[] args) {
        try {
            int num1 = 10 ;
            int num2 = 0 ;
            int result = num1 / num2 ;    // throw new ArithmeticException() ; 던짐
        } catch (ArithmeticException e) { // = new ArithmeticException() ; 받음
            e.printStackTrace();
            System.out.println("예외 처리 블럭");
        }
        System.out.println("매우 중요한 실행 코드 ...");

        // ArithmeticException -> RuntimeException : 실행 중 체크되는 예외
        // 컴파일 실행 O
        // 예외 처리 목적 : 서비스 중단을 막기 위해
    }
}
