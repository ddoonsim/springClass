package org.choongang.entities;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cglib.core.Local;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

/**
 * 공통 속성으로 쓸 클래스 --> 객체 생성 X, 상속만 가능하게 : 추상 클래스
 */
@Getter @Setter
@MappedSuperclass    // 공통 속성화를 위한 상위 클래스임을 알려주는 어노테이션
@EntityListeners(AuditingEntityListener.class)    // 날짜와 시간 감지를 위해 이벤트 리스너 필요
public abstract class Base {

    @CreatedDate
    @Column(updatable = false)    // UPDATE 쿼리 실행 시 데이터 수정 X
    private LocalDateTime createdAt ;
    @LastModifiedDate
    @Column(insertable = false)    // INSERT 쿼리 실행 시 데이터 수정 X
    private LocalDateTime modifiedAt ;
}
