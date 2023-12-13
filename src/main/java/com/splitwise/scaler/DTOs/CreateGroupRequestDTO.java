package com.splitwise.scaler.DTOs;

import lombok.Getter;

@Getter
public class CreateGroupRequestDTO {
    private Long userId;
    private String groupName;
}
