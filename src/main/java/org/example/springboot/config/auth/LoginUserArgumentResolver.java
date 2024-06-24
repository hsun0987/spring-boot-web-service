package org.example.springboot.config.auth;

import lombok.RequiredArgsConstructor;
import org.example.springboot.config.auth.dto.SessionUser;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.*;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Component
// HandlerMethodArgumentResolver 는 항상 WebMvcConfigurer(WebConfig)의 add..를 통해 추가해야됨
public class LoginUserArgumentResolver implements HandlerMethodArgumentResolver {
    private final HttpSession httpSession;

    @Override
    // 컨트롤러 메서드의 특정 파라미터를 지원하는지 판단
    // @LoginUser 어노테이션이 붙어있고 SessionUSer.class인 경우 true 반환
    public boolean supportsParameter(MethodParameter parameter) {
        boolean isLoginUserAnnotation = parameter.getParameterAnnotation(LoginUser.class) != null;
        boolean isUserClass = SessionUser.class.equals(parameter.getParameterType());

        return  isLoginUserAnnotation && isUserClass;
    }

    @Override
    // 파라미터에 전달할 객체 생성
    // 세션에서 객체를 가져옴
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        return httpSession.getAttribute("user");
    }
}
