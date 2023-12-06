package exam01;

public class Ex01 {
    public static void main(String[] args) {
        //Integer num1 = new Integer(10) ;
        //Integer num2 = new Integer(10) ;    <-- 다른 객체
        Integer num1 = Integer.valueOf(10) ;
        Integer num2 = Integer.valueOf(10) ;    // <-- 바이트 범위 내의 정수는 같은 객체
        Integer num3 = Integer.valueOf(10000000) ;
        Integer num4 = Integer.valueOf(10000000) ;    // <-- 바이트 범위 외의 정수는 다른 객체

        System.out.println("num1 : " + System.identityHashCode(num1));
        System.out.println("num2 : " + System.identityHashCode(num2));
        System.out.println(num1 == num2);
        System.out.println(num3 == num4);
        // long num2 = num1.longValue() ;

    }
}
