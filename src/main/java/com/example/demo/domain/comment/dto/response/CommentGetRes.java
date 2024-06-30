package com.example.demo.domain.comment.dto.response;

import com.example.demo.domain.user.dto.response.GetUser;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record CommentGetRes(
        Long id,
        Long boardId,
        String content,
        GetUser writer,
//        Integer likeCount,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
