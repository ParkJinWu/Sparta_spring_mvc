package com.sparta.springmvc.response;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//@Response Body ➡️ 데이터 반환

@Controller
@RequestMapping("/response")
public class ResponseController {

    @GetMapping("/json/string")
    @ResponseBody
    public String helloStringJson() {
        //Content - Type : text/html ➡️ HTTP에서는 Text라고 인식
        //Response Body
        // {"name" : "Robbie", "age" : 95}

        //Java는 JSON 타입을 지원하지 않기 때문에 JSON 형태의 String 타입으로 변환해서 사용
        return "{\"name\":\"Robbie\",\"age\":95}";
    }

    // Content - Type : application/json
    // Response Body
    // {"name" : "Robbie", "age" : 95}
    @GetMapping("/json/class")
    @ResponseBody
    public Star helloJsonClass() {
        //JSON형태로 반환을 해야하는데 모든 데이터를 전부 JSON형태로 만들기에는 부적합함
        //따라서 Spring내부적으로 JAVA의 객체를 JSON형태로 변환을 해준다. ➡️ application/json
        return new Star("Robbie",95);
    }
}
