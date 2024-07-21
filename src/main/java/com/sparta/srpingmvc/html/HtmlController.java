package com.sparta.srpingmvc.html;

import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/*
@Controller을 달고 아래 메서드에서 반환타입을 String으로 하면 리턴에 부합하는
페이지를 찾아서 반환한다.

1) http://localhost:8080/static-hello ➡️ 접근 불가(템플릿 없음)
 ㄴ> thymeleaf를 사용하지 않으면 Controller를 통해서 static > hello.html을 찾아서 반환 가능

2) http://localhost:8080/hello.html ➡️ 직접 접근 가능 (컨트롤러 거치지 않음)

3) redirect를 통해서는 컨트롤러로 접근 가능
* */

@Controller
public class HtmlController {
    @GetMapping("/static-hello")
    public String hello() {
        return "hello.html";
    }

    @GetMapping("/html/redirect")
    public String htmlStatic( ) {
        return "redirect:/hello.html";
    }

}

