package com.example.demo.domain.comment.controller;

import com.example.demo.global.payload.BaseStatus;
import com.example.demo.global.payload.ReasonDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum CommentErrorStatus implements BaseStatus {

    COMMENT_UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "COMMENT_4010", "해당 댓글에 대한 권한이 없습니다."),
    COMMENT_NOT_FOUND(HttpStatus.NOT_FOUND, "COMMENT_4040", "존재하지 않는 댓글입니다."),
    COMMENT_LIKE_NOT_FOUND(HttpStatus.NOT_FOUND, "COMMENT_4041", "아직 좋아요를 누르지 않은 댓글입니다."),
    COMMENT_LIKE_CONFLICT(HttpStatus.CONFLICT, "COMMENT_4090", "이미 좋아요를 누른 댓글입니다."),
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
