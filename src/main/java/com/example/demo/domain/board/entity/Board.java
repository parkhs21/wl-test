package com.example.demo.domain.board.entity;

import com.example.demo.domain.user.entity.User;
import com.example.demo.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board extends BaseEntity {

    @Id
    @Column(name = "board_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(length = 1000, nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "writer_id", nullable = false)
    private User writer;

    @Builder.Default
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "board_like",
            joinColumns = @JoinColumn(name = "board_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> likes = new ArrayList<>();
}
