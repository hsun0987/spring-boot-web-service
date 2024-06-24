package org.example.springboot.web;

import lombok.RequiredArgsConstructor;
import org.example.springboot.config.auth.LoginUser;
import org.example.springboot.config.auth.dto.SessionUser;
import org.example.springboot.service.posts.PostsService;
import org.example.springboot.web.dto.PostsResponseDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    // 기존에 httpSession으로 가져온 세션 정보 값을 @LoginUser 어노테이션으로 수정
    // 어느 컨트롤러에서든 @LoginUser만 사용하면 세션 정보를 가져올 수 있음
    public String index(Model model, @LoginUser SessionUser user){
        // Model : 서버 템플릿 엔진에서 사용할 수 있는 객체 저장
        // postsService.findAllDesc() -> posts 로 전달
        model.addAttribute("posts", postsService.findAllDesc());

        if (user != null){
            model.addAttribute("userName", user.getName());
        }

        // 머스테치 스타터로 인해서 앞경로와 뒤 파일 확장자가 자동 지정
        // src/main/resources/templates/ + "index" + .mustache 전달 -> view resolver 처리
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model){
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }

}
