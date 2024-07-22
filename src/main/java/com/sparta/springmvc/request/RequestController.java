package com.sparta.springmvc.request;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/*
    hello-request-form을 반환하는 Controller
* */

@Controller
@RequestMapping("/hello/request")
public class RequestController {

    @GetMapping("/form/html")
    public String helloForm() {
        return "hello-request-form";
    }

    // [Request sample]
    // GET http://localhost:8080/hello/request/star/Robbie/age/95
    // @PathVariable ➡️ URL 경로의 일부를 변수로 사용하여 매핑된 메서드에 전달할 수 있게 해주는 어노테이션
    @GetMapping("/star/{name}/age/{age}")
    @ResponseBody
    public String helloRequestPath(@PathVariable String name, @PathVariable int age)
    {
        return String.format("Hello, @PathVariable.<br> name = %s, age = %d", name, age);
    }

    // [Request sample]
    // GET http://localhost:8080/hello/request/form/param?name=Robbie&age=95
    // @RequestParam ➡️ 요청 URL에서 쿼리 파라미터를 매핑된 메서드의 매개변수로 전달하는 데 사용되는 어노테이션
    @GetMapping("/form/param")
    @ResponseBody
    public String helloGetRequestParam(@RequestParam(required = false) String name, int age) {
        return String.format("Hello, @RequestParam.<br> name = %s, age = %d", name, age);
    }


    // [Request sample]
    // POST http://localhost:8080/hello/request/form/param
    // Header
    //  Content type: application/x-www-form-urlencoded
    // Body(Payload)
    //  name=Robbie&age=95
    @PostMapping("/form/param")
    @ResponseBody
    public String helloPostRequestParam(@RequestParam String name, @RequestParam int age) {
        return String.format("Hello, @RequestParam.<br> name = %s, age = %d", name, age);
    }



}