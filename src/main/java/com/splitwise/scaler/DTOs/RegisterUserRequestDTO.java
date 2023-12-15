package com.splitwise.scaler.DTOs;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class RegisterUserRequestDTO {
    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @Email(message = "Email id is not valid.")
    private String email;

    @Size(min = 8, message = "Password must be atleast 8 characters.")
    private String password;
}
