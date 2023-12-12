package exam01;

import java.util.ArrayList;

public class Ex05 {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>() ;

        names.add("이름1") ;
        names.add("이름2") ;
        names.add("이름3") ;
        names.add("이름4") ;
        names.add("이름5") ;

        /*
        for (String name : names) {   // 컬렉션과 배열에서 주로 사용되는 향상된 for문
            System.out.println(name);
        }
        */
        names.forEach(System.out::println);  // 스트림을 이용
    }
}
