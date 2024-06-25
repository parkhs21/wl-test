package com.example.demo.global.exception;

import com.example.demo.global.payload.ApiPayload;
import com.example.demo.global.payload.CommonErrorStatus;
import com.example.demo.global.payload.ReasonDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.LinkedHashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice(annotations = {RestController.class})
public class GeneralExceptionHandler extends ResponseEntityExceptionHandler {

    // Valid 유효성 검사의 에러를 처리하는 핸들러
    @ExceptionHandler
    public ResponseEntity<Object> validation(ConstraintViolationException e, WebRequest request) {
        Map<String, String> errors = new LinkedHashMap<>();

        e.getConstraintViolations()
                .forEach(constraintViolation -> {
                    String fieldName = constraintViolation.getPropertyPath().toString().split("\\.")[1];
                    String errorMessage = constraintViolation.getMessage();
                    errors.merge(fieldName, errorMessage, (existingErrorMessage, newErrorMessage) -> existingErrorMessage + ", " + newErrorMessage);
                });

        return handleExceptionInternalArgs(e, CommonErrorStatus.BAD_REQUEST, HttpHeaders.EMPTY, request, errors);
    }

    // 선언한 에러(GeneralException)를 처리하는 핸들러
    @ExceptionHandler(value = GeneralException.class)
    public ResponseEntity onThrowException(GeneralException generalException, HttpServletRequest request) {
        // e.printStackTrace();
        return handleExceptionInternal(generalException, generalException.getErrorReason(), null, request);
    }

    // 임의의(처리하지 않은) 에러를 처리하는 핸들러
    @ExceptionHandler
    public ResponseEntity<Object> exception(Exception e, WebRequest request) {
        e.printStackTrace();
        return handleExceptionInternalFalse(e, CommonErrorStatus.INTERNAL_SERVER_ERROR, HttpHeaders.EMPTY, request, e.getMessage());
    }

    private ResponseEntity<Object> handleExceptionInternal(Exception e, ReasonDTO reason, HttpHeaders headers, HttpServletRequest request) {
        ApiPayload<Object> body = ApiPayload.onFailure(reason.code(), reason.message(),null);
        WebRequest webRequest = new ServletWebRequest(request);
        return super.handleExceptionInternal(e, body, headers, reason.httpStatus(), webRequest);
    }

    private ResponseEntity<Object> handleExceptionInternalFalse(Exception e, CommonErrorStatus errorStatus, HttpHeaders headers, WebRequest request, String errorPoint) {
        ApiPayload<Object> body = ApiPayload.onFailure(errorStatus, errorPoint);
        return super.handleExceptionInternal(e, body, headers, errorStatus.getHttpStatus(), request);
    }

    private ResponseEntity<Object> handleExceptionInternalArgs(Exception e, CommonErrorStatus errorStatus, HttpHeaders headers, WebRequest request, Map<String, String> errorArgs) {
        ApiPayload<Object> body = ApiPayload.onFailure(errorStatus, errorArgs);
        return super.handleExceptionInternal(e, body, headers, errorStatus.getHttpStatus(), request);
    }
}