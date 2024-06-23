package org.example.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
// JPA Entity 클래스들이 이 클래스를 상속할 경우 이 클래스의 필드들(createdDate, modifiedDate)도 칼럼으로 인식하도록
@MappedSuperclass
// Auditing 기능 포함
@EntityListeners(AuditingEntityListener.class)
// BaseTimeEntity 가 모든 Entity의 상위 클래스가 되어 Entity들의 등록, 수정 시간 자동으로 관리
public abstract class BaseTimeEntity {
    // Entity 가 생성되어 저장될 때 시간 자동 저장
    @CreatedDate
    private LocalDateTime createdDate;
    // 조회한 Entity의 값을 변결할 때 시간 자동 저장
    @LastModifiedDate
    private LocalDateTime modifiedDate;
}
