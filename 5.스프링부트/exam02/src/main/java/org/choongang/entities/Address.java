package org.choongang.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

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
}
