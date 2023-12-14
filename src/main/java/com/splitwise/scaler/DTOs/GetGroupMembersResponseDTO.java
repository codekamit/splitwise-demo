package com.splitwise.scaler.DTOs;

import com.splitwise.scaler.models.User;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class GetGroupMembersResponseDTO {
    private LocalDateTime timeStamp;
    private String message;
    private List<User> groupMembers;
}
