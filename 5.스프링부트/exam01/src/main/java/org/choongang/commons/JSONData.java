package org.choongang.commons;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor    // 기본 생성자
@RequiredArgsConstructor    // 필수 필드를 매개변수로 하는 생성자
public class JSONData<T> {
    private boolean success = true ;    // 응답 성공일 때 true
    private HttpStatus status = HttpStatus.OK;    // 응답 상태 코드(default = 200)
    @NonNull
    private T data ;    // 응답 성공 시, 응답 body 데이터 | data는 거의 매번 주입해야 하기 때문에 생성자 매개 변수로 추가
    private String message ;    // 실패 시, 에러 메세지
}
