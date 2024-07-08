package org.example.springboot.config.auth;

import lombok.*;
import org.example.springboot.domain.user.Role;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;

@RequiredArgsConstructor
// Spring Security 설정 활성화
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                // h2-console 화면을 사용하기 위해 해당 옵션 disable
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                    // URL 별 권한 관리 설정하는 옵션의 시작점(선언을 해야 antMatchers 사용 가능)
                    .authorizeHttpRequests()
                    // 권한 관리 대상 지정하는 옵션(URL, HTTP 메소드 별)
                    // permitAll() : 전체 열람 권한
                    // hasRole(Role.USER.name()) : user 권한을 가진 사람만 열람 가능
                    .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**").permitAll()
                    .antMatchers("/api/v1/**").hasRole(Role.USER.name())
                    // 설정된 값들 이외 나머지 URL
                    // authenticated() : 인증된 사용자(로그인한 사용자)에게만 허용
                    .anyRequest().authenticated()
                .and()
                    .logout()
                    .logoutSuccessUrl("/")
                .and()
                    .oauth2Login()
                    // 로그인 성공 이후 사용자 정보 가져올 때의 설정 담당
                    .userInfoEndpoint()
                    // 로그인 성공 시 후속 조치를 진행할 서비스
                    .userService(customOAuth2UserService);
    }
}
