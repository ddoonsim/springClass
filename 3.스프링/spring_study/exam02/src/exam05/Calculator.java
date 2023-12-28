package exam05;

/**
 * 인터페이스
 */
public interface Calculator {
    int num = 10 ;    // 상수 -> 컴파일러가 public static final 자동 인식

    int add(int num1, int num2) ;   // 추상메서드 -> 컴파일러가 public abstract으로 자동 인식

    /**
     * 인스턴스 메서드 : 재정의가 필수가 아닌 메서드
     */
    default int minus(int num1, int num2) {
        return num1 - num2 ;
    }
}
