package com.splitwise.scaler.controllers;

import com.splitwise.scaler.DTOs.RegisterUserRequestDTO;
import com.splitwise.scaler.DTOs.RegisterUserResponseDTO;
import com.splitwise.scaler.DTOs.ResponseStatus;
import com.splitwise.scaler.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    @Autowired
    private UserService userService;
    public RegisterUserResponseDTO registerUser(RegisterUserRequestDTO registerUserRequestDTO) {
        RegisterUserResponseDTO registerUserResponseDTO = new RegisterUserResponseDTO();
        userService.registerUser(registerUserRequestDTO.getFirstName(),
                    registerUserRequestDTO.getLastName(),
                    registerUserRequestDTO.getEmail(),
                    registerUserRequestDTO.getPassword());
        registerUserResponseDTO.setResponseStatus(ResponseStatus.SUCCESSFUL);
        return registerUserResponseDTO;
    }
}
