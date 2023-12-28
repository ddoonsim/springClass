package exam04;

public class Ex02 {
    public static void main(String[] args) {
        Calculator cal = new Calculator() {
            /**
             * 익명 자식 클래스의 추상 메서드 재정의
             */
            @Override
            public int add(int num1, int num2) {
                return num1 + num2 ;
            }
        } ;

        int result = cal.add(10, 20) ;
        System.out.println(result);
    }
}
