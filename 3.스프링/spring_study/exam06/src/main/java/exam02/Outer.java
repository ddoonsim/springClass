package exam02;

/**
 * 내부 클래스 공부
 */
public class Outer {

    /*
    void method() {
        /**
         * 지역 내부 클래스 : 메서드 지역 안에 정의된 클래스
         * method() 메서드가 실행 ==> 내부 클래스 실행됨


        class Inner {
            void innerMethod() {
                System.out.println("지역 내부 클래스");
            }
        }

        Inner in = new Inner() ;
        in.innerMethod();
    }*/

    Calculator method(int num3) {
        return new Calculator() {  // 익명 내부 클래스
            public int add(int num1, int num2) {
                System.out.println(num1 + num2 + num3);
                // 리턴 이후에는 스택의 임시 메모리는 제거됨
                // num3이 아직 유효하려면 스택 메모리에 저장되면 X
                // -> 상수화(final) : 데이터 영역 메모리에 생성
                // num3 = 40 ;    <-- 상수이기 때문에 값 변경 X
                return num1 + num2 + num3 ;
            }
        };
    }
}
