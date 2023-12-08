package exam04;

public class Ex01 {
    public static void main(String[] args) {
        Student s1 = new Student(1000, "이름1", "과목1") ;
        System.out.println(s1);

        Student s2 = new Student(1001, "이름2", "과목2") ;
        System.out.println(s2);

        Student s3 = s2 ;    // s3과 s2는 같은 주소값을 가지기 때문에 같은 객체를 참조함
        s3.id = 1002 ;
        s3.name = "이름3" ;
        s3.subject = "과목3" ;
        System.out.println(s3);
        System.out.println(s2);

        s1 = null ;    // 힙 영역 메모리의 객체와 연결이 끊김
                       // --> 연결이 끊긴 데이터는 garbage collector가 삭제함
    }
}
