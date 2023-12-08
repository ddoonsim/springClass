package exam01;

public class Ex03 {
    public static void main(String[] args) {

        try (MyResource my = new MyResource()) {
            // 자원 해제 메서드 자동 실행
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
