package org.example.springboot.web;

import lombok.RequiredArgsConstructor;
import org.example.springboot.service.posts.PostsService;
import org.example.springboot.web.dto.*;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private final PostsService postsService;

    // 등록
    @PostMapping("/api/v1/posts")
    public Long save(
            @RequestBody
            PostsSaveRequestDto requestDto
    ){
        return postsService.save(requestDto);
    }

    // 수정
    @PutMapping("/api/v1/posts/{id}")
    public Long update(
            @PathVariable
            Long id,

            @RequestBody
            PostsUpdateRequestDto requestDto
    ){
        return postsService.update(id, requestDto);
    }

    // 삭제
    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(
            @PathVariable Long id
    ) {
        postsService.delete(id);
        return id;
    }

    // 조회
    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById (
            @PathVariable Long id
    ){
        return postsService.findById(id);
    }
}
