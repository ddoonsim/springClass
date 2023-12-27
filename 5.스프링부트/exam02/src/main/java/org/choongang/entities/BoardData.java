package org.choongang.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class BoardData extends Base {

    @Id
    @GeneratedValue
    private Long seq ;
    @Column(length = 100, nullable = false)
    private String subject ;
    @Lob
    @Column(nullable = false)
    private String content ;

    @ManyToOne    // 외래키 생성하여 Member테이블과 조인됨
        // 게시글에서 회원 조회
    @JoinColumn(name = "userNo")    // Member의 기본키와 조인되는 외래키로 설정되는 컬럼명을 직접 설정
    private Member member ;
}
