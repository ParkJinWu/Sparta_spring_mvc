package com.sparta.springmvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sparta.springmvc.response.Star;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JacksonTest {

    @Test
    @DisplayName("Object To JSON : get Method 필요")
    void test1() throws JsonProcessingException {
        Star star = new Star("Robbie", 95);

        // Jackson 라이브러리의 ObjectMapper
        // 1) new연산자를 사용해서 객체를 만든다.
        // 2) ObjectMapper의 writeValueAsString메서드 파라미터 값으로 변환하고 싶은 Object의 객체를 넣는다.
        //   ㄴ> String타입으로 반환을 한다.
        // 3) 파라미터로 받은 값을 읽은 다음에 String타입의 JSON형태로 만들어준다.

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(star);

        System.out.println("json = " + json);
    }

    @Test
    @DisplayName("JSON To Object : 기본 생성자 & (get OR set) Method 필요")
    void test2() throws JsonProcessingException {
        String json = "{\"name\":\"Robbie\",\"age\":95}"; // JSON 타입의 String

        ObjectMapper objectMapper = new ObjectMapper(); // Jackson 라이브러리의 ObjectMapper

        //JSON To Object ➡️ deserialize : JSON형태의 String을 객체로 변환하는 과정
        // readValue() ➡️ (JSON 형태, 매핑할 객체)
        Star star = objectMapper.readValue(json, Star.class);
        System.out.println("star.getName() = " + star.getName());
        System.out.println("star.getAge() = " + star.getAge());
    }
}
