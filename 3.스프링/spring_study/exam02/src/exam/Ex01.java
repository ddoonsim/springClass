package exam;

public class Ex01 {
    public static void main(String[] args) {
        // 생성자 메서드 : 객체를 생성하는 역할(힙 메모리에 필요한 자원을 위한 공간 할당)
        C c = new C() ;    // -> super() = B() -> super() = A()

        // c는 a, b 객체 모두 될 수 있음
        A a = c ;
        B b = c ;
        A a2 = new C() ;
    }
}
