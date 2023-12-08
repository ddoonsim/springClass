package exam04;

public class Student {
    static int id ;    // 정적 변수
    String name ;
    String subject ;

    public Student(int id, String name, String subject) {
        this.id = id;
        this.name = name;
        this.subject = subject;
    }

    public static void staticMethod() {    // static 메서드
        System.out.println("정적 메서드");
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }
}
