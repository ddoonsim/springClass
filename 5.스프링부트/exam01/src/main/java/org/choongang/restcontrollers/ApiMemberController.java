package org.choongang.restcontrollers;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.choongang.commons.JSONData;
import org.choongang.entities.Member;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
@RestController    // 응답 헤더 contentType이 JSON 방식으로 변환    ## 주로, 데이터를 뷰 페이지로 전달할 때
@RequestMapping("/api/member")
public class ApiMemberController {

    @PostMapping    // Post 매핑을 폼 전송 없이 테스트할 수 있게 사전에 ARC 툴 설치
    public ResponseEntity<JSONData> join(@RequestBody @Valid RequestJoin form, Errors errors) {
                    // @RequestBody : application/json 형식의 요청 데이터 변환(JSON 요청을 처리)
        if(errors.hasErrors()) {
            // 에러가 발생한 모든 필드의 default 메세지를 가져옴
            List<String> messages = errors.getFieldErrors()
                    .stream()
                    .map(FieldError :: getDefaultMessage)
                    .toList();
            log.info("에러 : {}", messages.toString());  // 콘솔에 에러 메세지 출력

            String message = messages.stream().collect(Collectors.joining(", "));
            throw new RuntimeException(message) ;  // errorHandler로 예외 던짐
        }
        // 예외 X
        // status() : 응답 코드 --> 201으로 변경
        // header(헤더 명, 헤더 값 ... ) : 응답 헤더 직접 상세 설정
        // build() : 응답 바디 X
        /*return ResponseEntity.status(HttpStatus.CREATED)
                .header("CUSTOM_HEADER", "value1").build() ;*/

        // JSONData 이용
        HttpStatus status = HttpStatus.CREATED ;
        JSONData<Object> data = new JSONData<>() ;
        data.setStatus(status);  // 응답 코드 설정
        return ResponseEntity.status(HttpStatus.CREATED).body(data) ;  // JSONData 객체 body에 출력
    }

    @GetMapping
    /**
     * return : 객체 자체를 반환
     */
    public JSONData<Member> info() {
        Member member = Member.builder()
                .userNo(1L)
                .userId("user01")
                .userPw("12345678")
                .userNm("사용자01")
                .email("user01@test.org")
                .regDt(LocalDateTime.now())
                .modDt(LocalDateTime.now())
                .build() ;

        return new JSONData<>(member) ;    // JSONData 이용
    }

    @GetMapping("/list")
    public List<Member> list() {
        List<Member> members = IntStream.rangeClosed(1, 10)
                .mapToObj(i -> Member.builder()
                        .userNo(Long.valueOf(i))
                        .userId("user" + i)
                        .userPw("12345678")
                        .userNm("사용자" + i)
                        .email("user" + i + "@test.org")
                        .regDt(LocalDateTime.now())
                        .modDt(LocalDateTime.now())
                        .build()).toList() ;
        return members ;
    }

    @GetMapping("/message")
    public String message() {
        return "안녕하세요😊" ;
    }

    @GetMapping("/process")    // 응답 코드만 필요한 경우, body 데이터 X
    public void process() {
        System.out.println("처리...");
    }

    @ExceptionHandler(Exception.class)    // 이 컨트롤러 내에서 발생한 모든 예외 공통 처리
    public ResponseEntity errorHandler(Exception e) {
        // return e.getMessage() ;   // 화면에 에러 메세지 출력

        // 응답 코드 변경 & 응답 body에 에러 메세지 출력
        // return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage()) ;
        return ResponseEntity.badRequest().body(e.getMessage()) ;
    }
}
