package com.example.demo.domain.comment.exception;

import com.example.demo.global.exception.GeneralException;
import org.springframework.http.HttpStatus;

public class NotFoundCommentException extends GeneralException {

    public static final String code = "COMMENT_4040";
    public static final String message = "존재하지 않는 댓글입니다.";

    public NotFoundCommentException() {
        super(HttpStatus.NOT_FOUND, code, message);
    }
}