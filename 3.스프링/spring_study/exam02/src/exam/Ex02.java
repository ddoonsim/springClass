package exam;

public class Ex02 {
    public static void main(String[] args) {
        C c = new C() ;

        A a = new D() ;

        if (a instanceof C) {
            C c2 = (C)a ;    // 자동 형변환 X -> 강제 형변환 필요
            System.out.println("D -> C 로 타입 변환 ⭕");
        } else {
            System.out.println("D -> C 로 타입 변환 ❌");
        }
    }
}
