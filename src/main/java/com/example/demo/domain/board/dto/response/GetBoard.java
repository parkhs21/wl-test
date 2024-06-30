package com.example.demo.domain.board.dto.response;

import com.example.demo.domain.comment.dto.response.GetComment;
import com.example.demo.domain.user.dto.response.GetUser;

import java.time.LocalDateTime;
import java.util.List;

public record GetBoard(
        Long id,
        String title,
        String content,
        GetUser writer,
        Integer likeCount,
        List<GetComment> comments,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
