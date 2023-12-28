package org.choongang.entities;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Id 클래스 : 여러 컬럼을 조합하여 기본키를 만들기 위해
 */
@EqualsAndHashCode    // 유일성 보장을 위해
@AllArgsConstructor @NoArgsConstructor    // 생성자, 기본생성자 정의
public class BoardViewId {
    private Long seq ;
    private int uid ;
}
