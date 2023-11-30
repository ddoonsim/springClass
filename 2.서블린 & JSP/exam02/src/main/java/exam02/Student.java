package exam02;

import java.util.Objects;

public class Student {

    private int id ;            // 학번
    private String name ;       // 학생명

    public Student() {
        // 객체 생성 이후 실행
        id = 1000 ;
    }

    private String subject ;    // 과목

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Student(int id, String name, String subject) {
        this.id = id;
        this.name = name;
        this.subject = subject;
    }


    public int hashCode() {
        return Objects.hash(id, name, subject) ;
    }

    @Override
    public boolean equals(Object obj) {
        Student s2 = (Student) obj ;
        if(id == s2.id && name.equals(s2.name) && subject.equals(s2.subject)) {
            return true ;
        }
        return false;
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
