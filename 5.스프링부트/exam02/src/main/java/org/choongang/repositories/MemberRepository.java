package org.choongang.repositories;

import org.choongang.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository 인터페이스
 */
public interface MemberRepository extends JpaRepository<Member, Long> {    // 상속만으로도 기본적인 쿼리 수행 가능
    // 구현체는 자동으로 생성됨

    Member findByEmail(String email) ;
}
