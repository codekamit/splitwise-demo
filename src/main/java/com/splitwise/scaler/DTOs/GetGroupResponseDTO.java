package com.scaler.splitwise.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetGroupResponseDTO {
    private Long id;
    private String groupName;
    private int noOfUsers;
}
