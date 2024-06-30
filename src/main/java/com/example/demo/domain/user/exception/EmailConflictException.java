package com.example.demo.domain.user.exception;

import com.example.demo.global.exception.GeneralException;
import org.springframework.http.HttpStatus;

public class EmailConflictException extends GeneralException {

    public static final String code = "USER_4090";
    public static final String message = "이미 존재하는 이메일입니다.";

    public EmailConflictException() {
        super(HttpStatus.CONFLICT, code, message);
    }
}