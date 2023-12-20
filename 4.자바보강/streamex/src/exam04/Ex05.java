package exam04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Ex05 {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("이름1", "이름2", "이름1", "이름3", "이름4") ;
        Set<String> names2 = names.stream().collect(Collectors.toSet()) ;
        System.out.println(names2);

        /*ArrayList<String> names3 = names.stream().collect(Collectors.toCollection(() -> new ArrayList<>())) ;*/
        ArrayList<String> names3 = names.stream().collect(Collectors.toCollection(ArrayList::new)) ;
        System.out.println(names3);
    }
}
