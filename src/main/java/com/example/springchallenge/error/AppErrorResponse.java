package com.example.springchallenge.error;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AppErrorResponse {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Date timestamp;
    private int code;
    private String status;
    private String message;
    private Object data;

    public AppErrorResponse() {
        this.timestamp = new Date();
    }

    public AppErrorResponse(HttpStatus httpStatus, String message) {
        this();

        this.code = httpStatus.value();
        this.status = httpStatus.name();
        this.message = message;
    }

    public AppErrorResponse(HttpStatus httpStatus, String message, Object data) {
        this(httpStatus, message);

        this.data = data;
    }
}
