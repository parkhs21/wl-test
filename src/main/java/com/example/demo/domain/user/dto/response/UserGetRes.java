package com.example.demo.domain.user.dto.response;

import lombok.Builder;

@Builder
public record UserGetRes(
    Long id,
    String name,
    String email
) {
}
