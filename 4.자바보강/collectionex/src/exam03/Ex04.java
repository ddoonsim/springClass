package exam03;

import java.util.*;

public class Ex04 {
    public static void main(String[] args) {
        //HashMap<String, String> members = new HashMap<>() ;
        // 정렬 기준 기본값 : 키 자료형의 Comparable 인터페이스
        // 대안 정렬 기준 java.util.Comparator 인터페이스
        TreeMap<String, String> members = new TreeMap<>(Comparator.reverseOrder()) ;

        members.put("user02", "김이름") ;
        members.put("user01", "이이름") ;
        members.put("user03", "박이름") ;
        //members.put("user02", "(수정)김이름") ;

        //members.remove("user02") ;

        //String name = members.get("user02");
        //System.out.println(name);

        Set<Map.Entry<String, String>> entries = members.entrySet() ;
        // 순서쌍을 하나씩 가져오기
        for (Map.Entry<String, String> entry : entries) {
            System.out.printf("key=%s, value=%s%n", entry.getKey(), entry.getValue());
        }
        Set<String> keys = members.keySet() ;
        Collection<String> values = members.values() ;

        System.out.println(keys);
        System.out.println(values);
    }
}
