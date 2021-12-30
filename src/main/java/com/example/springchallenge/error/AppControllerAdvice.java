package com.example.springchallenge.error;

import java.io.PrintWriter;
import java.io.StringWriter;

import com.example.springchallenge.exception.AppErrorException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AppControllerAdvice {

    @ExceptionHandler(AppErrorException.class)
    public ResponseEntity<AppErrorResponse> handleAppErrorExceptions(Exception ex) {
        AppErrorException appErrorException = (AppErrorException) ex;

        HttpStatus httpStatus = appErrorException.getStatus();

        return new ResponseEntity<>(
                new AppErrorResponse(
                        httpStatus,
                        appErrorException.getMessage(),
                        appErrorException.getData()),
                httpStatus);
    }
}
