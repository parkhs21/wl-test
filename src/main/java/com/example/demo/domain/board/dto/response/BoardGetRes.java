package com.example.demo.domain.board.dto.response;

import com.example.demo.domain.user.dto.response.UserGetRes;
import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record BoardGetRes(
        Long id,
        String title,
        String content,
        UserGetRes writer,
        Integer likeCount,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
