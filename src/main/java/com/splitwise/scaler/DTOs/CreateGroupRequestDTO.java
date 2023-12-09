package com.splitwise.scaler.DTOs;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
public class CreateGroupRequestDTO {
    private Long userId;
    private String groupName;
}
