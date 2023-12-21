package org.choongang.tests;

import lombok.extern.slf4j.Slf4j;
import org.choongang.entities.Member;
import org.choongang.repositories.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.data.domain.Sort.Order.asc;
import static org.springframework.data.domain.Sort.Order.desc;

@Slf4j
@SpringBootTest    // 테스트를 위한 설정 자동 추가
public class JdbcEx01 {

    @Autowired
    private JdbcTemplate jdbcTemplate ;  // 너무 복잡한 쿼리문을 직접 작성해야 하는 경우 => jdbcTemplate
    @Autowired
    private MemberRepository repository ;

    @Test
    void test1() {    // 메서드로 쿼리 수행 가능
        List<Member> members = (List<Member>) repository.findAll() ;   // SELECT * FROM MEMBER 쿼리문 실행
        members.forEach(System.out::println);
    }

    @Test
    void test2() {
        Member member = repository.findById(22L).orElse(null) ;  // 기본키로 조회 쿼리문 실행

        member.setUserNm("(수정)사용자01");
        member.setModDt(LocalDateTime.now());

        repository.save(member) ;    // UPDATE 쿼리문 자동 실행
    }

    @Test
    void test3() {
        Member member = repository.findByUserId("user01") ;    // 쿼리 메서드로 userId와 일치하는 데이터 조회 쿼리문 실행
        log.info(member.toString());
    }

    @Test
    void test4() {
        // keyword 문자열이 포함되어 있는 데이터 조회 쿼리문 실행
        List<Member> members = repository.findByUserNmContainingOrUserIdContainingOrderByRegDtDesc("용", "id") ;
        members.forEach(System.out::println);
    }

    @Test
    void test5() {
        List<Member> members = repository.getMembers("용", "se") ;
        members.forEach(System.out::println);
    }

    @Test
    void test6() {    // 표준쿼리가 오라클에 호환이 되지 않기 때문에 오류 발생

        // Order는 Sort의 내부 static 클래스
        /*Pageable pageable = PageRequest.of(3, 10, Sort.by(Sort.Order.desc("regDt"), Sort.Order.asc("userId"))) ;*/
        Pageable pageable = PageRequest.of(3, 10, Sort.by(desc("regDt"), asc("userId"))) ;  // 코드 단순화

        Page<Member> data = repository.findByUserNmContaining("용", pageable) ;

        List<Member> members = data.getContent() ;  // 페이지의 내용을 리스트 타입으로 반환
        long total = data.getTotalElements() ;  // 전체 개수
        int totlaPage = data.getTotalPages() ;  // 전체 페이지 개수
    }
}
