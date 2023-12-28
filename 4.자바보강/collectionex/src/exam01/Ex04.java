package exam01;

import java.util.Vector;

public class Ex04 {
    public static void main(String[] args) {

        Vector<String> names = new Vector<>(3) ;
        names.add("이름1") ;
        names.add("이름2") ;
        names.add("이름3") ;
        names.add("이름4") ;
        System.out.println("capacity : " + names.capacity());
        // 처음 설정한 공간을 넘어서서 데이터가 추가되면 기존 공간의 두 배로 증가

    }
}
