package exam04;

public class Ex01 {
    public static void main(String[] args) {
        Calculator cal = new SimpleCalculator() ;    // 다형성
        int res = cal.add(10, 20) ;
        System.out.println(res);

        int num = cal.num ;    // 추상 클래스의 객체가 됨
        System.out.println(num);
    }
}
