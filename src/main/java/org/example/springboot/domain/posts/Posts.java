package org.example.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

// Lombok
@Getter
// 기본 생성자 자동 추가
@NoArgsConstructor
// JPA
// 테이블과 링크될 클래스임을 나타내는 어노테이션
@Entity
// ★ Entity 클래스에서는 절대 Setter 메소드 생성 x -> 차후 기능 변경 시 복잡해짐 방지
// => builder 를 통해 값을 채움
public class Posts {
    // PK
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    // 해당 클래스의 빌더 패턴 클래스 생성
    @Builder
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
