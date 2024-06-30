package com.example.demo.domain.user.exception;

import com.example.demo.global.exception.GeneralException;
import org.springframework.http.HttpStatus;

public class BadRequestUserException extends GeneralException {

    public static final String code = "USER_4000";
    public static final String message = "활성화된 사용자는 삭제할 수 없습니다.";

    public BadRequestUserException() {
        super(HttpStatus.BAD_REQUEST, code, message);
    }
}
