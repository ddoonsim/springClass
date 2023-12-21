package org.choongang.repositories;

import org.choongang.entities.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * CrudRepository<entity, id> 인터페이스를 상속 --> 프록시 형태로 구현체가 자동 생성
 *  ==> 쿼리문을 작성하지 않고 실행할 수 있는 메서드 사용 가능
 */
public interface MemberRepository extends CrudRepository<Member, Long> {

    // 쿼리 메서드를 추상 메서드로 정의 ==> 자동으로 만들어진 구현체에서 자동으로 쿼리문을 실행하는 메서드 생성
    Member findByUserId(String userId) ;    // userId와 일치하는 데이터 조회

    // 너무 긴 이름의 메서드는 쿼리문을 직접 작성할 것을 추천
    List<Member> findByUserNmContainingOrUserIdContainingOrderByRegDtDesc(String keyword1, String keyword2) ;

    // 페이징을 포함하는 쿼리문
    Page<Member> findByUserNmContaining(String key, Pageable pageable) ;

    // 직접 쿼리문을 작성하는 경우
    @Query("SELECT * FROM MEMBER " +
            "WHERE USER_NM LIKE '%:key1%' OR USER_ID LIKE '%:key2%' " +
            "ORDER BY REG_DT DESC")
    List<Member> getMembers(@Param("key1") String keword1, @Param("key2") String keyword2) ;
}
