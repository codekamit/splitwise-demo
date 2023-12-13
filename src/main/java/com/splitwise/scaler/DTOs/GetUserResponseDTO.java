package com.splitwise.scaler.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetUserResponseDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String emailId;
}
