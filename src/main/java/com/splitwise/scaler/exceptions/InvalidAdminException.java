package com.splitwise.scaler.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "The requested user is not the Admin")
public class InvalidAdminException extends RuntimeException {
}
