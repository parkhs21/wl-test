package com.example.demo.domain.comment.dto.response;

import com.example.demo.domain.user.dto.response.UserGetRes;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record CommentGetRes(
        Long id,
        Long boardId,
        String content,
        UserGetRes writer,
        Integer likeCount,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
