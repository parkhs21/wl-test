package com.example.demo.domain.comment.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CommentLike {

        @EmbeddedId
        private CommentLikeId id;
}
