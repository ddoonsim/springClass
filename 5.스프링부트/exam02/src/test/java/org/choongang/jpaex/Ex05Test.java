package org.choongang.jpaex;

import com.querydsl.core.BooleanBuilder;
import org.choongang.entities.BoardData;
import org.choongang.entities.QBoardData;
import org.choongang.repositories.BoardDataRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.TestPropertySource;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.data.domain.Sort.Order.desc;

@SpringBootTest
@TestPropertySource(properties = "spring.profiles.active=test")
public class Ex05Test {

    @Autowired
    private BoardDataRepository repository ;

    @BeforeEach
    void init() {
        List<BoardData> items = new ArrayList<>() ;
        for(int i = 1; i <= 10; i++) {
            BoardData item = new BoardData() ;
            item.setSubject("제목" + i);
            item.setContent("내용" + i);
            items.add(item) ;
        }
        repository.saveAllAndFlush(items) ;    // 쿼리 10번 수행하여 데모 데이터 저장
    }

    @Test
    void test1() {
        List<BoardData> items = repository.getSubjects("목") ;
        items.forEach(System.out::println);
    }

    @Test
    void test2() {
        QBoardData boardData = QBoardData.boardData ;
        List<BoardData> items = (List<BoardData>) repository.findAll(boardData.subject.contains("목")) ;

        items.forEach(System.out::println);
    }

    @Test
    void test3() {
        QBoardData boardData = QBoardData.boardData ;
        List<BoardData> items = (List<BoardData>) repository.findAll(boardData.subject.contains("목"), Sort.by(desc("createdAt"))) ;

        items.forEach(System.out::println);
    }

    @Test
    void test4() {
        QBoardData boardData = QBoardData.boardData ;
        Pageable pageable = PageRequest.of(1, 3, Sort.by(desc("createdAt"))) ;

        Page<BoardData> data = repository.findAll(boardData.subject.contains("목"), pageable) ;
    }

    @Test
    @DisplayName("조건식이 여러 개인 경우")
    void test5() {
        QBoardData boardData = QBoardData.boardData ;
        BooleanBuilder andBuilder = new BooleanBuilder() ;
        BooleanBuilder orBuilder = new BooleanBuilder() ;    // Predicate의 구현 클래스

        andBuilder.and(boardData.seq.in(1L, 3L, 5L)) ;
        orBuilder.or(boardData.subject.contains("10")).or(boardData.content.contains("5")) ;    // or로 연결된 조건문 생성
        andBuilder.and(orBuilder) ;    // or조건을 소괄호로 묶어서 and조건과 합침

        List<BoardData> items = (List<BoardData>) repository.findAll(andBuilder) ;
        // BooleanBuilder가 Predicate의 구현 클래스이기 때문에 매개 변수에 BooleanBuilder의 객체 대입 가능
        items.forEach(System.out::println);
    }
}
