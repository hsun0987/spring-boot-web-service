package org.example.springboot.web.dto;

import lombok.*;

@Getter
@RequiredArgsConstructor
// 선언된 모든 final 필드가 포함된 생성자를 생성
public class HelloResponseDto {
    private final String name;
    private final int amount;
}

// Ctrl + Shift + T = 테스트 코드 생성 단축키
