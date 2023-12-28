package exam02;

public class Ex01 {
    public static void main(String[] args) {
        Box<Apple> appleBox = new Box<>() ;
        appleBox.setItem(new Apple());

        Apple apple = appleBox.getItem() ;  // 타입안정성, 형변환 X
        Box<Pear> pearBox = new Box<>() ;
    }
}
