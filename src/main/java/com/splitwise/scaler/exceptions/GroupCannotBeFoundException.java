package com.scaler.splitwise.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Group cannot be found.")
public class GroupCannotBeFoundException extends Throwable {
}
