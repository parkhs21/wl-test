package com.example.demo.domain.board.exception;

import com.example.demo.global.exception.GeneralException;
import org.springframework.http.HttpStatus;

public class NotFoundBoardException extends GeneralException {

    public static final String code = "BOARD_4040";
    public static final String message = "존재하지 않는 게시글입니다.";

    public NotFoundBoardException() {
        super(HttpStatus.NOT_FOUND, code, message);
    }
}