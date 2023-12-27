package org.choongang.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.choongang.commons.MemberType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity    // 테이블을 만드는 기준이 됨
public class Member extends Base {    // 공통 속성화를 위한 클래스를 상속함으로써 공통 속성 자동 추가
    @Id     // Primary Key임을 명시
    @GeneratedValue    // 키값을 위한 시퀀스 자동 생성
    private Long seq ;
    @Column(length = 80, unique = true, nullable = false)    // unique, not null 제약 조건 설정
    private String email ;
    @Column(length = 40, nullable = false)    // not null 제약 조건 설정, length : varchar2 길이 설정
    private String name ;
    @Column(length = 65, nullable = false)    // 컬럼명은 password가 아닌 userPw로 설정,
                                                  // not null 제약 조건 설정
    private String password ;
    @Enumerated(EnumType.STRING)    // EnumType의 기본값 : ORDINAL(상수의 위치 번호, 정수값)
                                    // 순서가 바뀔 경우 문제가 생기기 때문에 반드시 STRING으로 변경해야 함!!!
    @Column(length = 10)
    private MemberType type ;    // enum 클래스

    @ToString.Exclude    // StackOverflowError 발생을 해결하기 위해 순환참조의 고리 끊기
    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)    // 1 : n 일대다 연관 관계 매핑
        // ManyToOne이 있어야 OneToMany가 가능
        // 회원 측에서 게시글 조회
        // OneToMany는 fetch의 기본값이 LAZY
    private List<BoardData> items = new ArrayList<>() ;

    @OneToOne(fetch = FetchType.LAZY)    // 일대일 매핑
    @JoinColumn(name = "addressNo")
    private Address address ;
}
