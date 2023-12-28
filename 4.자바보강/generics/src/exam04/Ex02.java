package exam04;

public class Ex02 {
    public static void main(String[] args) {
        Student s1 = new Student(1000, "이름1", "과목1") ;
        Student s2 = new Student(1001, "이름2", "과목2") ;

        System.out.println(s1.toString());
        System.out.println(s2);
    }
}
