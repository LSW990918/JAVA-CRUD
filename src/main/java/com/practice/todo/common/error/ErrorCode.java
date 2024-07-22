package com.practice.todo.common.error;

import org.springframework.http.HttpStatus;

public enum ErrorCode {

    MODEL_NOT_FOUND(HttpStatus.NOT_FOUND, 1001, "존재하지 않는 정보입니다.");
    private final HttpStatus httpStatus;
    private final int code;
    private final String message;

    ErrorCode(HttpStatus httpStatus, int code, String message) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
