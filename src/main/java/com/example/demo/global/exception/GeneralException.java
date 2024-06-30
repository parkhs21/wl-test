package com.example.demo.global.exception;

import com.example.demo.global.payload.ReasonDTO;
import org.springframework.http.HttpStatus;

public class GeneralException extends RuntimeException {

    private final ReasonDTO reason;

    public GeneralException(HttpStatus status, String code, String message) {
        super(message);
        this.reason = new ReasonDTO(status, false, code, message);
    }

    public ReasonDTO getErrorReason() {
        return this.reason;
    }
}