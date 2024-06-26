package com.example.demo.domain.comment.dto.request;

import jakarta.validation.constraints.*;

public record CommentCreateReq(
        @NotNull @Positive
        Long boardId,
        @NotBlank @Size(max = 1000)
        String content
) {
}
