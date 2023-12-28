package exam01;

@FunctionalInterface  // 함수형 인터페이스임을 명시 --> 단일 기능 수행
// 추상 메서드가 1개만 정의되어 있는지를 체크
public interface Calculator {
    int square(int num) ;
    // int root(int num) ; 람다식에 쓰인 인터페이스는 추상 메서드는 하나만 정의 가능

    static int two(int num1) {
        return num1 * 2 ;
    }
}
