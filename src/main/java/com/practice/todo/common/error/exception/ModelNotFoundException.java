package com.practice.todo.common.error.exception;

import com.practice.todo.common.error.ErrorCode;

public class ModelNotFoundException extends RuntimeException {

    private final ErrorCode errorCode;

    public ModelNotFoundException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}

