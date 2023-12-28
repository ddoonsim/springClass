package exam04;

public class SimpleCalculator extends Calculator {
    // 인스턴스 메서드 재정의
    @Override
    public int add(int num1, int num2) {
        return num1 + num2 ;
    }
}
