package org.choongang.jpaex;

import org.choongang.entities.BoardData;
import org.choongang.repositories.BoardDataRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@TestPropertySource(properties = "spring.profiles.active=test")
public class Ex03Test {

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
        BoardData data = new BoardData() ;
        data.setSubject("제목") ;
        data.setContent("내용") ;

        /*repository.save(data) ;    // em.persist(data)와 동일 = 변화 감지 시작(영속 상태)
        repository.flush();    // 쿼리 실행*/
        data = repository.saveAndFlush(data) ;    // persist(data) + flush() 와 동일한 기능

        data.setSubject("(수정)제목");
        //repository.saveAndFlush(data) ;    // UPDATE 쿼리 실행
        repository.save(data) ;    // persist(data) : 영속 상태

        // 조회 시 암묵적으로 flush()가 먼저 실행 --> 조회
        // flush() 하지 않아도, UPDATE 쿼리 먼저 실행 --> SELECT 쿼리 실행
        BoardData data2 = repository.findById(data.getSeq()).orElse(null) ;
        System.out.println(data2);
    }

    @Test
    void test2() {
        List<BoardData> items = repository.findAll() ;
        items.forEach(System.out::println);
    }
}
