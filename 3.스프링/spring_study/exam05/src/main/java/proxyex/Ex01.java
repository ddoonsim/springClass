package proxyex;

public class Ex01 {
    public static void main(String[] args) {
        long stime = System.nanoTime() ;    // 공통 기능

        ImplCalculator cal1 = new ImplCalculator() ;    // 핵심 기능
        long result1 = cal1.factorial(10L) ;

        long etime = System.nanoTime() ;    // 공통 기능
        System.out.printf("Impl 걸린 시간 : %d%n", etime - stime);
        System.out.printf("cal1 : %d%n", result1);

        stime = System.nanoTime() ;    // 공통 기능

        RecCalculator cal2 = new RecCalculator() ;    // 핵심 기능
        long result2 = cal2.factorial(10L) ;

        etime = System.nanoTime() ;    // 공통 기능
        System.out.printf("Rec 걸린 시간 : %d%n", etime - stime);
        System.out.printf("cal2 : %d%n", result2);
    }
}
