package com.splitwise.scaler.RestController;

import com.splitwise.scaler.DTOs.*;
import com.splitwise.scaler.DTOs.ResponseStatus;
import com.splitwise.scaler.models.User;
import com.splitwise.scaler.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/_api")
public class UserRESTController {

    @Autowired
    private UserService userService;

    @PostMapping("users")
    public @ResponseBody ResponseEntity<ResponseMessage> registerUser(@Valid @RequestBody RegisterUserRequestDTO registerUserRequestDTO) {
        userService.registerUser(registerUserRequestDTO.getFirstName(),
                registerUserRequestDTO.getLastName(),
                registerUserRequestDTO.getEmail(),
                registerUserRequestDTO.getPassword());

        ResponseMessage responseMessage = new ResponseMessage.Builder()
                .TimeStamp(LocalDateTime.now())
                .HttpStatusCode(HttpStatusCode.valueOf(200))
                .HttpStatus(HttpStatus.OK)
                .Message("User Registered Successfully")
                .Path("users/id")
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(responseMessage);
    }

    @GetMapping("users/{id}")
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
