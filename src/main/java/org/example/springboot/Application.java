package org.example.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// ★ 이 어노테이션의 위치부터 설정 읽기 시작 -> 프로젝트의 최상단 위치 !!
// 스프링 부트의 자동설정, 스프링 Bean 읽기,생성 모두 자동 설정
@SpringBootApplication
public class Application {
    public static void main(String[] args){
        // run -> 내장 WAS(웹 어플리케이션 서버) 실행 => 언제 어디서나 같은 환경으로 스프링 부트 배포를 위함
        // 톰캣 X, 스프링 부트로 만들어진 Jar 파일로 실행됨
        SpringApplication.run(Application.class, args);
    }
}
