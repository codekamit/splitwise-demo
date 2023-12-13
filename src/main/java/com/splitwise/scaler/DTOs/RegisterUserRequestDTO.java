package com.scaler.splitwise.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class RegisterUserRequestDTO {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
