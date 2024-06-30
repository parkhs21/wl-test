package com.example.demo.domain.user.dto.response;

public record GetUser(
    Long id,
    String name,
    String email
) {
}
