package com.example.demo.domain.board.dto.response;

import com.example.demo.domain.comment.dto.response.CommentGetRes;
import com.example.demo.domain.user.dto.response.GetUser;
import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

@Builder
public record BoardGetRes(
        Long id,
        String title,
        String content,
        GetUser writer,
        Integer likeCount,
        List<CommentGetRes> comments,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
