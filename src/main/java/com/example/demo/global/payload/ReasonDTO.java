package com.example.demo.global.payload;

import org.springframework.http.HttpStatus;

public record ReasonDTO (
        HttpStatus httpStatus,
        Boolean isSuccess,
        String code,
        String message
) { }