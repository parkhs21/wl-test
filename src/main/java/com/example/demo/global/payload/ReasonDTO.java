package com.example.demo.global.payload;

import lombok.Builder;
import org.springframework.http.HttpStatus;

@Builder
public record ReasonDTO (
        HttpStatus httpStatus,
        Boolean isSuccess,
        String code,
        String message
) { }