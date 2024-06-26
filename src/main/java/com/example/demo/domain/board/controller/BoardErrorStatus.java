package com.example.demo.domain.board.controller;

import com.example.demo.global.payload.BaseStatus;
import com.example.demo.global.payload.ReasonDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum BoardErrorStatus implements BaseStatus {

    BOARD_UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "BOARD_4010", "해당 게시글에 대한 권한이 없습니다."),
    BOARD_NOT_FOUND(HttpStatus.NOT_FOUND, "BOARD_4040", "존재하지 않는 게시글입니다."),
    BOARD_LIKE_NOT_FOUND(HttpStatus.NOT_FOUND, "BOARD_4041", "아직 좋아요를 누르지 않은 게시글입니다."),
    BOARD_LIKE_CONFLICT(HttpStatus.CONFLICT, "BOARD_4090", "이미 좋아요를 누른 게시글입니다."),
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
