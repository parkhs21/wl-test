package com.example.demo.domain.comment.dto.response;

import com.example.demo.domain.comment.entity.Comment;
import com.example.demo.domain.user.dto.response.GetUser;
import com.example.demo.domain.user.service.UserMapper;

import java.time.LocalDateTime;

public record GetComment(
        Long id,
        Long boardId,
        String content,
        GetUser writer,
//        Integer likeCount,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public GetComment(Comment comment) {
        this(comment.getId(), comment.getBoard().getId(), comment.getContent(), UserMapper.toUserGetRes(comment.getWriter()), comment.getCreatedAt(), comment.getUpdatedAt());
    }
}
