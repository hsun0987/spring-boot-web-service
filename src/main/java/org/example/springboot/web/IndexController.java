package org.example.springboot.web;

import lombok.RequiredArgsConstructor;
import org.example.springboot.service.posts.PostsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model){
        // Model : 서버 템플릿 엔진에서 사용할 수 있는 객체 저장
        // postsService.findAllDesc() -> posts 로 전달
        model.addAttribute("posts", postsService.findAllDesc());
        // 머스테치 스타터로 인해서 앞경로와 뒤 파일 확장자가 자동 지정
        // src/main/resources/templates/ + "index" + .mustache 전달 -> view resolver 처리
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }

}
