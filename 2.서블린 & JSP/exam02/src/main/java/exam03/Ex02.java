package exam03;

public class Ex02 {
    public static void main(String[] args) {
        C c = new C() ;    // C -> C, B, A : 다형성
        A a = c ;
        B b = c ;

        A aa = new C() ;
    }
}
