package com.example.demo.domain.user.entity;

import com.example.demo.domain.user.dto.request.UserUpdateReq;
import com.example.demo.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false)
    private String name;

    @Column(length = 50, nullable = false, unique = true)
    private String email;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    private UserStatus status = UserStatus.ACTIVE;      // ACTIVE,INACTIVE

    public void update(UserUpdateReq req) {
        this.name = req.name();
        this.email = req.email();
    }

    public void delete() {
        this.status = UserStatus.INACTIVE;
    }
}
