package com.example.demo.domain.comment.dto.request;

import jakarta.validation.constraints.*;

public record CommentCreateReq(
        @NotBlank @Size(max = 1000)
        String content
) {
}
