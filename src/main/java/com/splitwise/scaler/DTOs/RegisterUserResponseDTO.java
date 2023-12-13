package com.scaler.splitwise.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterUserResponseDTO {
    private String message;
    private ResponseStatus responseStatus;
}
