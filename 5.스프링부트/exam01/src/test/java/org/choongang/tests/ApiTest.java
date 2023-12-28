package org.choongang.tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.choongang.entities.Member;
import org.choongang.restcontrollers.RequestJoin;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

/**
 * API 통합 테스트
 */
@SpringBootTest  // 필수
@AutoConfigureMockMvc   // 통합테스트를 위한 설정 자동 추가
public class ApiTest {

    @Autowired
    private MockMvc mockMvc ;  // 서버를 켜지 않고 테스트하기 위한 필수 의존성

    @Test
    @DisplayName("회원가입 성공 시 응답 코드 201")
    void joinTest() throws Exception {

        RequestJoin form = new RequestJoin() ;
        form.setUserId("user01");
        form.setUserPw("12345678");
        form.setConfirmPw("12345678");
        form.setUserNm("사용자01");
        form.setEmail("user01@test.org");
        form.setRegDt(LocalDateTime.now());    // java.time 패키지는 변환이 불가

        ObjectMapper om = new ObjectMapper() ;
        om.registerModule(new JavaTimeModule()) ;    // java.time 패키지를 JSON으로 변환하기 위해 필요한 모듈
        String body = om.writeValueAsString(form) ;  // RequestJoin의 객체 --> JSON 문자열로 변환

        System.out.println(body);

        mockMvc.perform(
                post("/api/member")
                        // 헤더 설정
                        //.header("Content-Type", "application/json")
                        .header("Content-Type", MediaType.APPLICATION_JSON)  // 위 코드와 동일
                                                    // MediaType : 자주 쓰는 Content-Type을 상수로 정의
                        .characterEncoding("UTF-8")
                        .content(body)    // 매개 변수 : body 데이터 문자열
                ).andDo(print())
                .andExpect(status().isCreated()) ;    // 응답 코드 201
    }

    @Test
    @DisplayName("JSON 문자열 --> Member 단일 객체로 변환")
    void infoTest() throws Exception {
        String body = mockMvc.perform(get("/api/member"))
                .andDo(print())    // 자세한 정보 조회
                .andReturn().getResponse()
                .getContentAsString(Charset.forName("UTF-8"));  // 바디 데이터 --> 문자열로

        ObjectMapper om = new ObjectMapper() ;
        om.registerModule(new JavaTimeModule()) ;
        Member member = om.readValue(body, Member.class) ;    // JSON 문자열 --> Member 객체로 변환
        System.out.println(member);
    }

    @Test
    @DisplayName("JSON 문자열 --> 복잡한 자바 객체로 변환")
    void listTest() throws Exception {
        String body = mockMvc.perform(get("/api/member/list"))
                .andDo(print())
                .andReturn().getResponse()    // 응답 객체 가져오기
                .getContentAsString(Charset.forName("UTF-8")) ;  // 바디 데이터 --> 문자열로

        ObjectMapper om = new ObjectMapper() ;
        om.registerModule(new JavaTimeModule()) ;

        // 복잡한 구조의 자바 객체로 변환
        List<Member> members = om.readValue(body, new TypeReference<>() {}) ;
        members.forEach(System.out::println);
    }
}
