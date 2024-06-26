package com.example.demo.domain.board.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record BoardUpdateReq(
        @NotBlank @Size(max = 100)
        String title,
        @NotBlank @Size(max = 1000)
        String content
) {
}
