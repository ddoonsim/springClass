package exam02;

public class Ex01 {
    public static void main(String[] args) {
        Outer out = new Outer() ;
        Calculator cal = out.method(20);
        cal.add(10, 30) ;
    }
}
