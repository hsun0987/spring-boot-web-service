package org.example.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

// DAO - DB Layer 접근자
// JpaRepository<Entity 클래스, PK 타입> : 기본적인 CRUD 자동 생성
public interface PostsRepository extends JpaRepository<Posts, Long> {
}
