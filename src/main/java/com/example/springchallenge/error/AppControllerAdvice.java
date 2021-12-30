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
    private StringWriter stringWriter = new StringWriter();
    private PrintWriter printWriter = new PrintWriter(stringWriter);

    @ExceptionHandler(AppErrorException.class)
    public ResponseEntity<AppErrorResponse> handleAppErrorExceptions(Exception ex) {
        AppErrorException appErrorException = (AppErrorException) ex;

        HttpStatus httpStatus = appErrorException.getStatus();

        appErrorException.printStackTrace(printWriter);

        String stackTrace = stringWriter.toString();

        return new ResponseEntity<>(
                new AppErrorResponse(
                        httpStatus,
                        appErrorException.getMessage(),
                        stackTrace,
                        appErrorException.getData()),
                httpStatus);
    }
}
