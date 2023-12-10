package com.splitwise.scaler.RestController;

import com.splitwise.scaler.DTOs.RegisterUserRequestDTO;
import com.splitwise.scaler.DTOs.RegisterUserResponseDTO;
import com.splitwise.scaler.DTOs.ResponseStatus;
import com.splitwise.scaler.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserRESTController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public @ResponseBody ResponseEntity<RegisterUserResponseDTO> registerUser(@RequestBody RegisterUserRequestDTO registerUserRequestDTO) {
        RegisterUserResponseDTO registerUserResponseDTO = new RegisterUserResponseDTO();
        try {
            userService.registerUser(registerUserRequestDTO.getFirstName(),
                    registerUserRequestDTO.getLastName(),
                    registerUserRequestDTO.getEmail(),
                    registerUserRequestDTO.getPassword());
            registerUserResponseDTO.setResponseStatus(ResponseStatus.SUCCESSFUL);
            registerUserResponseDTO.setMessage("User register successfully.");
            return ResponseEntity.status(HttpStatus.CREATED).body(registerUserResponseDTO);
        }
        catch(Exception e) {
            registerUserResponseDTO.setResponseStatus(ResponseStatus.FAILED);
            registerUserResponseDTO.setMessage("Request to register failed");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(registerUserResponseDTO);
        }
    }
}
