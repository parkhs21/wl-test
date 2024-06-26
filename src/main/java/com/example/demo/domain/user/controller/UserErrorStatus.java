package com.example.demo.domain.user.controller;

import com.example.demo.global.payload.BaseStatus;
import com.example.demo.global.payload.ReasonDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum UserErrorStatus implements BaseStatus {

    USER_NOT_INACTIVE(HttpStatus.BAD_REQUEST, "USER_4000", "활성화된 사용자는 삭제할 수 없습니다."),
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "USER_4040", "존재하지 않는 사용자입니다."),
    USER_EMAIL_CONFLICT(HttpStatus.CONFLICT, "USER_4090", "이미 존재하는 이메일입니다."),
    ;

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ReasonDTO getReason() {
        return ReasonDTO.builder()
                .isSuccess(false)
                .code(code)
                .message(message)
                .httpStatus(httpStatus)
                .build();
    }
}
