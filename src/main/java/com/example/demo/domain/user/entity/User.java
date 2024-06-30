package com.example.demo.domain.user.entity;

import com.example.demo.domain.user.dto.request.UpdateUser;
import com.example.demo.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Table(name = "member")
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

    @Enumerated(EnumType.STRING)
    private UserStatus status = UserStatus.ACTIVE;      // ACTIVE,INACTIVE

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public void update(UpdateUser updateUser) {
        this.name = updateUser.name();
        this.email = updateUser.email();
    }

    public void delete() {
        this.status = UserStatus.INACTIVE;
    }
}
