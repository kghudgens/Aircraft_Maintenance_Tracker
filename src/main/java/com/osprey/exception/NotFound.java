package com.osprey.exception;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public class NotFound {
    String message;
    Throwable throwable;
    HttpStatus httpStatus;
    ZonedDateTime timestamp;

    public NotFound(String message, Throwable throwable, HttpStatus httpStatus, ZonedDateTime timestamp) {
        this.message = message;
        this.throwable = throwable;
        this.httpStatus = httpStatus;
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }


}
