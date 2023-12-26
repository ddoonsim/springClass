package org.choongang.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity    // 테이블을 만드는 기준이 됨
@Table(name = "USERS",     // 테이블 명을 USERS로 변경하여 설정
        indexes = @Index(name = "idx_member_createdAt", columnList = "createdAt DESC"))    // 인덱스 정의 ==> 자동으로 인덱스 생성
public class Member {
    @Id     // Primary Key임을 명시
    @GeneratedValue    // 키값을 위한 시퀀스 자동 생성
    private Long seq ;
    private String email ;
    private String name ;
    private String password ;
    private LocalDateTime createdAt ;
    private LocalDateTime modifiedAt ;
}
