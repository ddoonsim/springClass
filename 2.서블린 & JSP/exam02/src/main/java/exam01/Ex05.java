package exam01;

public class Ex05 {
    public static void main(String[] args) {
        String str1 = "abc" ;
        String str2 = "abc" ;
        System.out.println(str1 == str2);
        System.out.println("equals : " + str1.equals(str2));
        System.out.println("str1 : " + System.identityHashCode(str1));
        System.out.println("str2 : " + System.identityHashCode(str2));

        int num1 = 10 ;
        int num2 = 10 ;
        System.out.println(num1 == num2);
    }
}
