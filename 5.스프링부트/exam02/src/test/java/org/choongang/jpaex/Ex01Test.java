package org.choongang.jpaex;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.choongang.entities.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
@Transactional    // EntityManager를 사용할 때는 반드시 트랜잭션 처리해야 함
@TestPropertySource(properties = "spring.profiles.active=test")    // application-test.yml 파일로 설정
public class Ex01Test {

    @PersistenceContext    // @Autowired와 동일하게 의존성 주입
    private EntityManager em ;

    @BeforeEach    // 모든 테스트 실행 이전에 실행되는 부분
    void init() {
        Member member = new Member() ;
        member.setSeq(1L);
        member.setEmail("user01@test.org");
        member.setName("사용자01");
        member.setPassword("12345678");
        member.setCreatedAt(LocalDateTime.now());

        em.persist(member);
        em.flush();
        em.clear();    // 영속 상태 엔티티 모두 비우기
    }

    @Test
    void test1() {
        Member member = new Member() ;
        member.setSeq(1L);
        member.setEmail("user01@test.org");
        member.setName("사용자01");
        member.setPassword("12345678");
        member.setCreatedAt(LocalDateTime.now());

        em.persist(member);    // 영속성 컨텍스트에 member를 넣어서 상태 변화 감지 시작
        em.flush() ;    // INSERT 쿼리 실행

        em.detach(member);    // 영속성 분리 : 상태 변화 감지 X ==> 이후 쿼리는 실행 X

        member.setName("(수정)사용자01");
        em.flush();    // UPDATE 쿼리 실행

        em. merge(member) ;    // 분리된 영속 성태 엔티티 --> 영속 상태로 변경, 변화 감지 O
        em.flush();    // 다시 영속성 상태 변화 감지를 했기 때문에 위 쿼리 실행 O

        /*em.remove(member);    // 영속성 상태를 제거 상태로 변경
        em.flush();    // DELETE 쿼리 실행*/
    }

    @Test
    void test2() {
        Member member = em.find(Member.class, 1L) ;    // 기본키로 조회
            // 영속성 상태 메모리에 존재하지 않는 데이터 ==> 쿼리 수행
        System.out.println(member);

        Member member2 = em.find(Member.class, 1L) ;    // 기본키로 조회
            // 영속성 상태 메모리에 이미 있는 경우 ==> 쿼리 수행 X, 성능 상에 이점이 있음
        System.out.println(member2);
    }

    @Test
    void test3() {
        List<Member> members = em.createQuery("SELECT m FROM Member m", Member.class)
                                .getResultList() ;
        members.forEach(System.out::println);
    }
}
