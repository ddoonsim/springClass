package exam01;

public class Student extends java.lang.Object {

    private int id ;            // 학번
    private String name ;       // 학생명
    private String subject ;    // 과목

    public Student(int id, String name, String subject) {
        this.id = id;
        this.name = name;
        this.subject = subject;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public boolean equals(Object obj) {
        Student s2 = (Student) obj ;
        if(id == s2.id && name.equals(s2.name) && subject.equals(s2.subject)) {
            return true ;
        }
        return false;
    }
}
