package org.choongang.repositories;

import org.choongang.entities.BoardData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Repository 인터페이스
 */
public interface BoardDataRepository extends JpaRepository<BoardData, Long> {

    // 쿼리 메서드
    List<BoardData> findBySubjectContaining(String keyword) ;
    Page<BoardData> findBySubjectContaining(String keyword, Pageable pageable) ;    // 페이징 관련 편의 기능 조회 가능
    List<BoardData> findBySubjectContainingOrderBySeqDesc(String keyword) ;  // 정렬 조건 추가
}
