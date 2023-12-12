package exam01;

import java.util.ArrayList;
import java.util.Iterator;

public class Ex05 {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>() ;

        names.add("이름1") ;
        names.add("이름2") ;
        names.add("이름3") ;
        names.add("이름4") ;
        names.add("이름5") ;

        // 반복자 패턴, 반복은 한 번만 가능
        Iterator<String> iter = names.iterator() ;
        while (iter.hasNext()) {
            String name = iter.next();
            System.out.println(name);
        }
        iter = names.iterator();  // 커서를 다시 요소의 처음으로 이동시킴
        while (iter.hasNext()) {
            String name = iter.next();
            System.out.println(name);
        }

        System.out.println("-------------------");
        /*
        for (String name : names) {   // 컬렉션과 배열에서 주로 사용되는 향상된 for문
            System.out.println(name);
        }
        */
        names.forEach(System.out::println);  // 스트림을 이용
    }
}
