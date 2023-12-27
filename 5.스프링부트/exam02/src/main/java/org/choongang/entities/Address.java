package org.choongang.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
public class Address {
    @Id @GeneratedValue
    private Long seq ;
    @Column(length = 10, nullable = false)
    private String zipcode ;
    @Column(length = 80, nullable = false)
    private String addr1 ;
    @Column(length = 80)
    private String addr2 ;

    @ToString.Exclude    // 상대적으로 덜 쓰는 필드를 배제하여 순환참조의 고리 끊기
    @OneToOne(mappedBy = "address")    // OneToOne이지만 주인이 아니기 mappedBy로 주인 명시 ==> 때문에 조회만 가능
    private Member member ;
}
