package org.choongang.jpaex;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.choongang.entities.Member;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@SpringBootTest
@Transactional
@TestPropertySource(properties = "spring.profiles.active=test")
public class Ex02Test {

    @PersistenceContext
    private EntityManager em ;

    @Test
    void test1() {
        Member member = new Member() ;
        // member.setSeq()를 하지 않아도 @GeneratedValue로 키값 자동 생성
        member.setEmail("user01@test.org");
        member.setName("사용자01");
        member.setPassword("12345678");
        // member.setCreatedAt()을 실행 X --> @CreationTimestamp --> INSERT SQL 실행 시 날짜, 시간 자동 입력

        em.persist(member);
        em.flush();
        em.clear();    // DB 데이터를 직접 변경해야 @CreationTimestamp가 잘 작동하기 때문에 영속성 제거해야 확인 가능

        member = em.find(Member.class, member.getSeq()) ;

        System.out.println(member);

        try {
            Thread.sleep(3000);    // 3초 멈춤
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        member.setName("(수정)사용자01");
        em.flush();    // UPDATE 쿼리문 실행 --> @UpdateTimestamp --> modifiedAt의 값이 3초 뒤로 기록됨
        em.clear();    // DB 데이터를 직접 변경해야 @UpdateTimestamp가 잘 작동하기 때문에 영속성 제거해야 확인 가능

        member = em.find(Member.class, member.getSeq()) ;
        System.out.println(member);
    }

    @Test
    void test2() {
        Member member = new Member() ;
        member.setEmail("user01@test.org");
        member.setName("사용자01");
        member.setPassword("12345678");

        em.persist(member);
        em.flush();
        // @CreatedDate --> 엔티티의 생성 or 변경을 감지하여 날짜 저장하기 때문에 clear() 메서드 필요 X

        System.out.println(member);

        try {
            Thread.sleep(3000);
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        member.setName("(수정)사용자01");
        em.flush();
        // @LastModifiedDate --> clear() 메서드 필요 X

        System.out.println(member);
    }
}
