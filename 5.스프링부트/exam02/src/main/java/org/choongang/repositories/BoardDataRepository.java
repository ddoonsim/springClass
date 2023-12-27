package org.choongang.repositories;

import org.choongang.entities.BoardData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Repository 인터페이스
 */
public interface BoardDataRepository extends JpaRepository<BoardData, Long>,
        QuerydslPredicateExecutor<BoardData> {    // 기존 JpaRepository에 정의된 메서드에 매개변수가 Predecate인 형태 추가 --> 조건식 관련 판별식 추가

    // 쿼리 메서드
    List<BoardData> findBySubjectContaining(String keyword) ;
    Page<BoardData> findBySubjectContaining(String keyword, Pageable pageable) ;    // 페이징 관련 편의 기능 조회 가능
    List<BoardData> findBySubjectContainingOrderBySeqDesc(String keyword) ;  // 정렬 조건 추가

    @Query("SELECT b FROM BoardData b WHERE b.subject LIKE %:key% ORDER BY b.seq DESC")
        // JPQL : 엔티티를 대상으로 쿼리 수행
    List<BoardData> getSubjects(@Param("key") String keyword) ;

    @Query("SELECT b FROM BoardData b WHERE b.subject LIKE %:key%")
    Page<BoardData> getSubjects(@Param("key") String keyword, Pageable pageable) ;
}
