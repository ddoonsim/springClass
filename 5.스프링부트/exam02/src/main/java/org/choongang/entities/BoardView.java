package org.choongang.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.Data;

@Data
@Entity
@IdClass(BoardViewId.class)    // 여러 컬럼을 조합해서 기본키를 생성
public class BoardView {

    @Id
    private Long seq ;
    @Id
    @Column(name = "_uid")
    private int uid ;
}
