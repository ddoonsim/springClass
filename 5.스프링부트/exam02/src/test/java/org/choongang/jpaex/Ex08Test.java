package org.choongang.jpaex;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.choongang.entities.BoardData;
import org.choongang.entities.Hashtag;
import org.choongang.repositories.BoardDataRepository;
import org.choongang.repositories.HashtagRepository;
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
@TestPropertySource(properties = "spring.profiles.active=test")
public class Ex08Test {

    @Autowired
    private BoardDataRepository boardDataRepository ;
    @Autowired
    private HashtagRepository hashtagRepository ;

    @PersistenceContext
    private EntityManager em ;

    @BeforeEach
    void init() {
        List<Hashtag> tags = new ArrayList<>() ;
        for (int i = 1; i <= 5; i++) {
            Hashtag tag = new Hashtag() ;
            tag.setTag("태그" + i);
            tags.add(tag) ;
        }

        hashtagRepository.saveAllAndFlush(tags) ;

        List<BoardData> items = new ArrayList<>() ;
        for (int i = 1; i <= 5; i++) {
            BoardData item = new BoardData() ;
            item.setSubject("제목" + i);
            item.setContent("내용" + i);
            item.setTags(tags);
            items.add(item) ;
        }

        boardDataRepository.saveAllAndFlush(items) ;
        em.clear();    // ⚠️영속성 컨텍스트에 이미 존재하는 경우 쿼리를 실행하지 않고
                       // 영속성 컨텍스트 안에서 꺼내기 때문에 동기화에 문제가 생김 --> clear() 영속성 비우기 실행!!
    }

    @Test
    void test1() {
        BoardData item = boardDataRepository.findById(1L).orElse(null) ;
        List<Hashtag> tags = item.getTags() ;
        System.out.println(tags);
    }

    @Test
    @DisplayName("태그로 게시글 검색")
    void test2() {
        Hashtag tag = hashtagRepository.findById("태그1").orElse(null) ;
        System.out.println(tag);
        List<BoardData> items = tag.getItems() ;
        System.out.println(items);
        items.forEach(System.out::println);
    }
}
