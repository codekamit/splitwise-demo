package com.scaler.splitwise.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UserCannotBeFoundException.class)
    public final ResponseEntity<ErrorResponse> handleUserNotFoundException(UserCannotBeFoundException ex, WebRequest webRequest) {
        ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now(),
                HttpStatus.NOT_FOUND,
                ex.getClass().getAnnotation(ResponseStatus.class).reason(),
                webRequest.getDescription(false));
        return new ResponseEntity(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(GroupCannotBeFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public final ResponseEntity<ErrorResponse> handleGroupNotFoundException(GroupCannotBeFoundException ex, WebRequest webRequest) {
        ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now(),
                HttpStatus.NOT_FOUND,
                ex.getClass().getAnnotation(ResponseStatus.class).reason(),
                webRequest.getDescription(false));
        return new ResponseEntity(errorResponse, HttpStatus.NOT_FOUND);
    }
}
