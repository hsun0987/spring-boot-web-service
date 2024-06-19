package org.example.springboot.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class IndexController {
    @GetMapping("/")
    public String index(){
        // 머스테치 스타터로 인해서 앞경로와 뒤 파일 확장자가 자동 지정
        // src/main/resources/templates/ + "index" + .mustache 전달 -> view resolver 처리
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }
}
