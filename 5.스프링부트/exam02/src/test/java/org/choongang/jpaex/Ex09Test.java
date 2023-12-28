package org.choongang.jpaex;

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

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@TestPropertySource(properties = "spring.profiles.active=test")
public class Ex09Test {

    @Autowired
    private BoardDataRepository repository ;       // 자식
    @Autowired
    private MemberRepository memberRepository ;    // 부모

    @BeforeEach
    void init() {
        Member member = new Member() ;
        member.setEmail("user01@test.org");
        member.setPassword("12345678");
        member.setName("사용자01");

        memberRepository.saveAndFlush(member) ;

        List<BoardData> items = new ArrayList<>() ;
        for (int i = 1; i <= 3; i++) {
            BoardData item = new BoardData() ;
            item.setSubject("제목" + i);
            item.setContent("내용" + i);
            item.setMember(member);
            items.add(item) ;
        }

        repository.saveAllAndFlush(items) ;
    }

    @Test
    @DisplayName("영속성 전이 REMOVE")
    void test1() {
        Member member = memberRepository.findByEmail("user01@test.org") ;    // 영속성 안에서 삭제할 데이터 가져오기
        memberRepository.delete(member);    // 영속성 제거 상태로 전환할 뿐, DB에 반영되어 있지 않음
        memberRepository.flush();    // 삭제 쿼리 실행하여 DB에 영구 반영
        // 자식 엔터티의 데이터 삭제 --> 부모 엔터티의 데이터 삭제
    }
}
