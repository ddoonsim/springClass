package models;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Message implements InitializingBean, DisposableBean {

    public void send(String message) {
        System.out.printf("전송 메세지 : %s%n", message);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        // 초기화 단계에서 호출, 실행
        System.out.println("afterPropertiesSet() 호출");
    }

    @Override
    public void destroy() throws Exception {
        // 스프링 컨테이너에 있는 빈이 소멸 전에 호출됨
        // 주로 자원 해제 역할을 정의
        System.out.println("destroy() 호출");
    }
}
