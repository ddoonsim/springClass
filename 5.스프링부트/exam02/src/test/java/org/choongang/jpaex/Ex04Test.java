package org.choongang.jpaex;

import org.choongang.entities.BoardData;
import org.choongang.repositories.BoardDataRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.data.domain.Sort.Order.asc;
import static org.springframework.data.domain.Sort.Order.desc;

@SpringBootTest
//@TestPropertySource(properties = "spring.profiles.active=default")
@Transactional
public class Ex04Test {

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
//        List<BoardData> items = repository.findBySubjectContaining("목") ;
        List<BoardData> items = repository.findBySubjectContainingOrderBySeqDesc("목") ;
        items.forEach(System.out::println);
    }

    @Test
    void test2() {
        Pageable pageable = PageRequest.of(0, 3,
                Sort.by(desc("createdAt"), asc("seq")));    // 정렬 2개
        Page<BoardData> data = repository.findBySubjectContaining("목", pageable) ;

        List<BoardData> items = data.getContent() ;
        items.forEach(System.out::println);
    }

}
