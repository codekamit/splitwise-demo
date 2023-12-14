package com.splitwise.scaler.DTOs;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AddMemberRequestDTO {
    List<Long> userIds;
    private long groupId;
    private long adminId;
}
