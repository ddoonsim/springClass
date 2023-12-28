package exam;

public class C extends B {
    int numC = 30 ;

    public C() {
        super();    // 상위 클래스(B)의 생성자 메서드 | 작성하지 않아도 컴파일러가 자동으로 추가
        // this() : 생성자 메서드
        System.out.println("C 생성자");
    }
}
