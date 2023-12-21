package org.choongang.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    // 스프링부트가 USER_NO -> userId 자동 변환하여 매핑
    @Id  // userNo가 기본키(Primary Key)임을 알려주는 어노테이션
    private Long userNo ;
    private String userId ;
    @JsonIgnore    // JSON으로 변환 배제
    private String userPw ;
    private String userNm ;
    private String email ;
    @JsonFormat(pattern = "yyyy.MM.dd HH:mm")    // 원하는 형식으로 날짜 형식 변환
    private LocalDateTime regDt ;
    @JsonFormat(pattern = "yyyy.MM.dd HH:mm")
    private LocalDateTime modDt ;
}
