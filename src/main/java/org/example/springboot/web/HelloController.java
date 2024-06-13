package org.example.springboot.web;

import org.example.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// JSON 반환
@RestController
public class HelloController {

    // GET 요청 API
    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(
            // 외부에서 api로 넘긴 파라미터를 가져오는 어노테이션
            @RequestParam("name")
            String name,
            @RequestParam("amount")
            int amount
    ){
        return new HelloResponseDto(name, amount);
    }
}
