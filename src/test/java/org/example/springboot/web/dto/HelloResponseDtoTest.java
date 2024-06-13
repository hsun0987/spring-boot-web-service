package org.example.springboot.web.dto;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;
// junit vs assertj
// 1. CoreMatchers 와 달리 추가적으로 라이브러리 필요 x
// 2. 자동완성이 좀 더 확실하게 지원

public class HelloResponseDtoTest {
    @Test
    public void 롬복_기능_테스트(){
        // given
        String name = "test";
        int amount = 1000;

        // when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        // then
        // assertThat : 테스트 검증 라이브러리의 검증 메소드
        // 검증하고 싶은 대상을 메소드 인자로 받음
        // isEqualTo : 동등 비교 메소드
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);

    }
}