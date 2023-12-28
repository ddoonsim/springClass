package exam01;

public class Ex03 {
    public static void main(String[] args) {
        int num1 = 100 ;
        Integer num2 = new Integer(200) ;

        int num3 = num1 + num2 ;
        // num2.intValue() 를 컴파일러가 자동 추가
        System.out.println(num3);

        Integer num4 = num3 ;    //Integer.valueOf(num3)    --> 컴파일러가 자동 추가
        System.out.println();
    }
}
