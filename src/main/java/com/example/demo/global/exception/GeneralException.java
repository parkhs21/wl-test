package com.example.demo.global.exception;

import com.example.demo.global.payload.BaseStatus;
import com.example.demo.global.payload.ReasonDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException {

    private BaseStatus code;

    public ReasonDTO getErrorReason() {
        return this.code.getReason();
    }
}