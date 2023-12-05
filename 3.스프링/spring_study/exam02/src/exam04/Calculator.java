package exam04;

/**
 * 계산기 추상 클래스
 * 추상 클래스는 객체가 될 수 있다.
 */
public abstract class Calculator {
    int num = 10 ;    // Calculator의 객체가 만들어짐 = 메모리에 추상 클래스의 객체 공간 있음 -> 객체의 자원을 메모리에 저장 가능

    public abstract int add(int num1, int num2) ;    // 추상 메서드

    // 추상 메서드가 아닌 메서드
    public void commonMethod() {
        System.out.println("하위 클래스의 공통 기능");
    }
}
