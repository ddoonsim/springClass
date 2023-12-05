package exam05;

public class Ex01 {
    public static void main(String[] args) {
        Calculator cal = new SimpleCalculator() ;    // 다형성
        int result = cal.add(10, 20) ;
        System.out.println(result);

        int result2 = cal.minus(20, 10) ;
        System.out.println(result2);
    }
}
