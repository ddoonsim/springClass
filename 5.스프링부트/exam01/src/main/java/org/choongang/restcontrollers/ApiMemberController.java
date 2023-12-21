package org.choongang.restcontrollers;

import org.choongang.entities.Member;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.IntStream;

@RestController    // 응답 헤더 contentType이 JSON 방식으로 변환    ## 주로, 데이터를 뷰 페이지로 전달할 때
@RequestMapping("/api/member")
public class ApiMemberController {

    @GetMapping
    /**
     * return : 객체 자체를 반환
     */
    public Member info() {
        Member member = Member.builder()
                .userNo(1L)
                .userId("user01")
                .userPw("12345678")
                .userNm("사용자01")
                .email("user01@test.org")
                .regDt(LocalDateTime.now())
                .modDt(LocalDateTime.now())
                .build() ;

        return member ;
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
}
