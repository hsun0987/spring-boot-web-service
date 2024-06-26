package org.example.springboot.domain.posts;

import org.springframework.data.jpa.repository.*;

import java.util.List;

// DAO - DB Layer 접근자
// JpaRepository<Entity 클래스, PK 타입> : 기본적인 CRUD 자동 생성
public interface PostsRepository extends JpaRepository<Posts, Long> {

    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
}
