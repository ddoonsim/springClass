package org.choongang.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

/**
 * Member 테이블 데이터 VO 클래스
 */
@Data @Builder
@NoArgsConstructor @AllArgsConstructor    // 두 어노테이션 추가 ==> public 범위의 기본 생성자 사용 가능
public class Member {
    // 스프링부트가 USER_NO -> userId 자동 변환하여 인식
    @Id  // userNo가 기본키(Primary Key)임을 알려주는 어노테이션
    private Long userNo ;
    private String userId ;
    private String userPw ;
    private String userNm ;
    private String email ;
    private LocalDateTime regDt ;
    private LocalDateTime modDt ;
}
