package com.sparta.springmvc.html;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/*
@Controller을 달고 아래 메서드에서 반환타입을 String으로 하면 리턴에 부합하는
페이지를 찾아서 반환한다.

1) http://localhost:8080/static-hello ➡️ 접근 불가(템플릿 없음)
 ㄴ> thymeleaf를 사용하지 않으면 Controller를 통해서 static > hello.html을 찾아서 반환 가능

2) http://localhost:8080/hello.html ➡️ 직접 접근 가능 (컨트롤러 거치지 않음)

3) redirect를 통해서는 컨트롤러로 접근 가능

4)thymeleaf을 적용해서 templates에 있는 html 반환을 할 때는 .html을 빼고 이름만 문자열로 보내도 뒤에 자동으로 붙여줘서
templates 폴더 안에 있는 html을 찾아서 반환한다.

즉 temlplates에 들어가있는 HTML을 찾을때는 html파일의 이름만 문자열로 반환을 해도된다.

* */

@Controller
public class HtmlController {

    private static long visitCount = 0;

    @GetMapping("/static-hello")
    public String hello() {
        return "hello.html";
    }

    @GetMapping("/html/redirect")
    public String htmlStatic( ) {
        return "redirect:/hello.html";
    }

    @GetMapping("/html/templates")
    public String htmlTemplates() {
        return "hello";
    }

    /*
     1) visitCount가 증감 연산자에 의해서 증가된다.
     2) "visit"이라는 이름으로 Model에 담긴다.
     3) 반환 할 때는 hello-visit라는 view name 정보를 전달
     4) Dispatcher Servlet에서 hello-visit.html을 확인하고, ViewResolver에
        의해서 Model의 "visit"이름으로 들어 있던 데이터를 hello-visit에 매핑해서 넣어줌

    * */
    @GetMapping("/html/dynamic")
    public String htmlDynamic(Model model) {
        visitCount++;
        //Model에 변동이 일어난 데이터를 넣는다
        model.addAttribute("visits", visitCount);
        //동적 페이지 만들 때 필요한 요소 : 필요한 데이터 모델 & view name의 정보
        return "hello-visit";
    }

}

