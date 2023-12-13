package com.splitwise.scaler.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
public class ErrorResponse {
    private LocalDateTime timeStamp;
    private HttpStatus httpStatus;
    private String message;
    private String description;
}
