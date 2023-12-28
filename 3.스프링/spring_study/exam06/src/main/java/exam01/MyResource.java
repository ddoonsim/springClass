package exam01;

public class MyResource implements AutoCloseable {    // 자동 자원 해제 인터페이스 구현 객체
    @Override
    public void close() throws Exception {
        System.out.println("자원 해제 close(),,,");
    }
}
