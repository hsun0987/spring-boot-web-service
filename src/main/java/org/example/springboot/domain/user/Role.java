package org.example.springboot.domain.user;

import lombok.*;

@Getter
@RequiredArgsConstructor
// 사용자의 권한을 관리할 Enum 클래스
public enum Role {

    // 권한 코드는 항상 앞에 ROLE_이 있어야함
    GUEST("ROLE_GUEST", "손님"),
    USER("ROLE_USER", "일반 사용자");

    private final String key;
    private final String title;
}
