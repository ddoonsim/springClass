package org.choongang.jpaex;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.choongang.entities.BoardData;
import org.choongang.entities.Member;
import org.choongang.repositories.BoardDataRepository;
import org.choongang.repositories.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Transactional
@TestPropertySource(properties = "spring.profiles.active=test")    // 주석 처리하면 오라클 쿼리로 실행
public class Ex06Test {

    @Autowired
    private BoardDataRepository boardDataRepository ;
    @Autowired
    private MemberRepository memberRepository ;

    @PersistenceContext
    private EntityManager em ;

    @BeforeEach    // 초기 데이터 추가
    void init() {
        Member member = new Member() ;
        member.setEmail("user01@test.org");
        member.setName("사용자01");
        member.setPassword("12345678");

        memberRepository.saveAndFlush(member) ;    // 데모데이터 추가

        List<BoardData> items = new ArrayList<>() ;
        for(int i = 1; i <= 10; i++) {
            BoardData item = new BoardData() ;
            item.setSubject("제목" + i);
            item.setContent("내용" + i);
            item.setMember(member);
            items.add(item) ;
        }
        boardDataRepository.saveAllAndFlush(items) ;
        em.clear();    // 엔티티 비우기
    }

    @Test
    @DisplayName("추가된 데이터와 join 확인")
    void test1() {
        BoardData data = boardDataRepository.findById(1L).orElse(null) ;
        Member member = data.getMember() ;
        System.out.println(member);
    }

    @Test
    void test2() {
        Member member = memberRepository.findByEmail("user01@test.org") ;
        List<BoardData> items = member.getItems() ;

        items.forEach(System.out::println);    // BoardData의 toString() 호출
    }
}
