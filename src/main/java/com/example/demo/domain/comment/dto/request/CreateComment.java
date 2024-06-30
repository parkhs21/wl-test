package com.example.demo.domain.comment.dto.request;

import jakarta.validation.constraints.*;

public record CreateComment(
        @NotBlank @Size(max = 1000)
        String content
) {
}
