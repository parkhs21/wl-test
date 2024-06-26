package com.example.demo.domain.user.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserCreateReq(
        @NotBlank @Size(min = 3, max = 20)
        String name
) {
}
