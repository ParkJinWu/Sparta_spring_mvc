package com.sparta.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/*
* @ResponseBody ->컨트롤러 메서드의 반환 값을 HTTP 응답 본문으로 변환해주는 어노테이션
* 경로는 중복 가능 / 메서드까지는 중복 X
* @RequestMapping("/api") -> 괄호 안에 있는 경로의 클래스나 메서드와 매핑하는 어노테이션
* */

@Controller
@RequestMapping("/api")
public class HelloController {
    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello World~!";
    }

    @GetMapping("/get")
    @ResponseBody String get() {
        return "GET Method 요청";
    }

    @PostMapping("/hello")
    @ResponseBody
    public String post() {
        return "POST Method 요청";
    }

    @PutMapping("/put")
    @ResponseBody
    public String put() {
        return "PUT Method 요청";
    }

    @DeleteMapping("/delete")
    @ResponseBody
    public String delete() {
        return "DELETE Method 요청";
    }
}
