package com.example.demo.domain.comment.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CommentUpdateReq(
        @NotBlank @Size(max = 1000)
        String content
) {
}
