package com.example.demo.domain.board.entity;

import com.example.demo.domain.board.dto.request.UpdateBoard;
import com.example.demo.domain.comment.entity.Comment;
import com.example.demo.domain.user.entity.User;
import com.example.demo.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board extends BaseEntity {

    @Id
    @Column(name = "board_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String title;

    @Lob
    @Column(length = 1000, nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "writer_id")
    private User writer;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "board_like",
            joinColumns = @JoinColumn(name = "board_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private Set<User> likes = new HashSet<>();

    @OneToMany(mappedBy = "board", cascade = {CascadeType.REMOVE})
    private List<Comment> comments = new ArrayList<>();


    public Board(String title, String content, User writer) {
        this.title = title;
        this.content = content;
        this.writer = writer;
    }

    public void update(UpdateBoard updateBoard) {
        this.title = updateBoard.title();
        this.content = updateBoard.content();
    }

    public void like(User user) {
        if (this.likes.contains(user)) {
            this.likes.remove(user);
        } else {
            this.likes.add(user);
        }
    }

    public void addComment(Comment comment) {
        this.comments.add(comment);
    }
}
