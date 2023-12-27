package org.choongang.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Hashtag {
    @Id
    private String tag ;

    @ToString.Exclude    // 순환참조 해결
    @ManyToMany(mappedBy = "tags", fetch = FetchType.EAGER)    // 다대다 매핑 : 주인 엔티티 명시 필요 --> 주인 테이블의 컬럼이 중간 테이블의 맨 앞에 위치
    private List<BoardData> items = new ArrayList<>() ;
}
