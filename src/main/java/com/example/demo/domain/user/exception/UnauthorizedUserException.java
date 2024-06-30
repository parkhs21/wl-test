package com.example.demo.domain.user.exception;

import com.example.demo.global.exception.GeneralException;
import org.springframework.http.HttpStatus;

public class UnauthorizedUserException extends GeneralException {

    public static final String code = "USER_4010";
    public static final String message = "해당 댓글에 대한 권한이 없습니다.";

    public UnauthorizedUserException() {
        super(HttpStatus.BAD_REQUEST, code, message);
    }
}
