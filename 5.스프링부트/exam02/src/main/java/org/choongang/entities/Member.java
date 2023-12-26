package org.choongang.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.choongang.commons.MemberType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity    // 테이블을 만드는 기준이 됨
@Table(name = "USERS",     // 테이블 명을 USERS로 변경하여 설정
        indexes = @Index(name = "idx_member_createdAt", columnList = "createdAt DESC"))    // 인덱스 정의 ==> 자동으로 인덱스 생성
//@EntityListeners(AuditingEntityListener.class)    // 엔티티 변화 이벤트를 감지
public class Member extends Base {    // 공통 속성화를 위한 클래스를 상속함으로써 공통 속성 자동 추가
    @Id     // Primary Key임을 명시
    @GeneratedValue    // 키값을 위한 시퀀스 자동 생성
    private Long seq ;
    @Column(length = 80, unique = true, nullable = false)    // unique, not null 제약 조건 설정
    private String email ;
    @Column(length = 40, nullable = false)    // not null 제약 조건 설정, length : varchar2 길이 설정
    private String name ;
    @Column(length = 65, name = "userPw", nullable = false)    // 컬럼명은 password가 아닌 userPw로 설정,
                                                  // not null 제약 조건 설정
    private String password ;

    //@Lob    // 여러 줄의 데이터를 저장하는 타입으로 --> CLOB 타입
    @Transient    // DB에 반영되지 않을 필드
    private String introduction ;
    @Enumerated(EnumType.STRING)    // EnumType의 기본값 : ORDINAL(상수의 위치 번호, 정수값)
                                    // 순서가 바뀔 경우 문제가 생기기 때문에 반드시 STRING으로 변경해야 함!!!
    @Column(length = 10)
    private MemberType type ;    // enum 클래스

/*
//    @CreationTimestamp    // INSERT SQL 실행 시 날짜, 시간 자동 입력
    @CreatedDate    // 엔티티에서 생성되어 저장될 때 시간 자동 저장, 이벤트 리스너 필요
    private LocalDateTime createdAt ;
//    @UpdateTimestamp    // UPDATE SQL 실행 시 날짜, 시간 자동 입력
    @LastModifiedDate    // 조회한 엔티티의 값이 변경되었을 때 시간 자동 저장, 이벤트 리스너 필요
    private LocalDateTime modifiedAt ;
*/

/*    @Temporal(TemporalType.DATE)    // 날짜 타입 매핑, java.time API 사용할 시, 필요 X
    @Temporal(TemporalType.TIME)    // 시간
    @Temporal(TemporalType.TIMESTAMP)    // 날짜 & 시간
    public Date dt ;*/
}
