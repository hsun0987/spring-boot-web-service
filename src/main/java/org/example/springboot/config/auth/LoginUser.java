package org.example.springboot.config.auth;

import java.lang.annotation.*;

// 이 어노테이션이 생성될 수 있는 위치 지정
// PARAMETER -> 메소드의 파라미터로 선언된 객체에서만 사용 가능
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
// @interface -> 어노테이션 클래스로 지정
public @interface LoginUser {
}
