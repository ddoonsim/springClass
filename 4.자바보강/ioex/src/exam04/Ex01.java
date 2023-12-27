package exam04;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

public class Ex01 {
    public static void main(String[] args) {
        Map<String, Object> data = new HashMap<>() ;

        try (FileOutputStream fos = new FileOutputStream("book.obj");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            Book b1 = new Book("책1", "저자1", "출판사1") ;
            Book b2 = new Book("책2", "저자2", "출판사2") ;

            data.put("book1", b1) ;
            data.put("book2", b2) ;
            data.put("str", "안녕하세요.") ;

            oos.writeObject(data);    // Map컬렉션에 담으면 순서 상관없이 원하는 데이터를 조회할 수 있음

            /*oos.writeObject(b1);
            oos.writeObject(b2);
            oos.writeObject("안녕하세요😊");*/
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
