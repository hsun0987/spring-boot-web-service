package org.example.springboot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// JSON 반환
@RestController
public class HelloController {

    // GET 요청 API
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }
}
