package com.example.demo.domain.user.exception;

import com.example.demo.global.exception.GeneralException;
import org.springframework.http.HttpStatus;

public class NotFoundUserException extends GeneralException {

    public static final String code = "USER_4040";
    public static final String message = "존재하지 않는 사용자입니다.";

    public NotFoundUserException() {
        super(HttpStatus.NOT_FOUND, code, message);
    }
}
