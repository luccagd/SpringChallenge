package com.example.springchallenge.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppErrorException extends RuntimeException {
    private HttpStatus status = null;
    private Object data = null;

    public AppErrorException() {
        super();
    }

    public AppErrorException(String message) {
        super(message);
    }

    public AppErrorException(HttpStatus status, String message) {
        this(message);

        this.status = status;
    }

    public AppErrorException(HttpStatus status, String message, Object data) {
        this(status, message);

        this.data = data;
    }
}
