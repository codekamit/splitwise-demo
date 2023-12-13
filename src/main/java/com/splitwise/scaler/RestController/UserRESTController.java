package com.scaler.splitwise.RestController;

import com.scaler.splitwise.DTOs.GetUserResponseDTO;
import com.scaler.splitwise.DTOs.RegisterUserRequestDTO;
import com.scaler.splitwise.DTOs.RegisterUserResponseDTO;
import com.scaler.splitwise.DTOs.ResponseStatus;
import com.scaler.splitwise.models.User;
import com.scaler.splitwise.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/_api")
public class UserRESTController {

    @Autowired
    private UserService userService;

    @PostMapping("user")
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

    @GetMapping("user/{id}")
    public GetUserResponseDTO getUser(@PathVariable Long id) {
        User user = userService.getUser(id);
        GetUserResponseDTO getUserResponseDTO = new GetUserResponseDTO();
        getUserResponseDTO.setId(id);
        getUserResponseDTO.setFirstName(user.getFirstName());
        getUserResponseDTO.setLastName(user.getLastName());
        getUserResponseDTO.setEmailId(user.getEmailId());
        return getUserResponseDTO;
    }
}
