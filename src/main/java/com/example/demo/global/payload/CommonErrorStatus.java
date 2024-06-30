package com.example.demo.global.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum CommonErrorStatus implements BaseStatus {

    // 공통 에러
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "COMMON_400", "잘못된 요청"),
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "COMMON_401", "권한 없음"),
    FORBIDDEN(HttpStatus.FORBIDDEN, "COMMON_403", "금지된 요청"),
    NOT_FOUND(HttpStatus.NOT_FOUND, "COMMON_404", "찾을 수 없음"),
    METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED, "COMMON_405", "허용되지 않은 메소드"),
    CONFLICT(HttpStatus.CONFLICT, "COMMON_409", "충돌"),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON_500", "서버 에러, 관리자에게 문의하세요")
    ;

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ReasonDTO getReason() {
        return new ReasonDTO(httpStatus, false, code, message);
    }
}