package com.example.demo.domain.comment.entity;

import com.example.demo.domain.board.entity.Board;
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
public class Comment extends BaseEntity {

    @Id
    @Column(name = "comment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "writer_id")
    private User writer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id", nullable = false)
    private Board board;

    @Builder.Default
    @OneToMany(mappedBy = "id.comment", cascade = {CascadeType.ALL}, orphanRemoval = true)
    private List<CommentLike> likes = new ArrayList<>();

    public void update(String content) {
        this.content = content;
    }

    public void like(CommentLike commentLike) {
        this.likes.add(commentLike);
    }

    public void unlike(CommentLike commentLike) {
        this.likes.remove(commentLike);
    }
}
