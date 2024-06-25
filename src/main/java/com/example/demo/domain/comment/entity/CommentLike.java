package com.example.demo.domain.comment.entity;

import com.example.demo.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CommentLike {

        @Id
        @Column(name = "comment_like_id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
}
