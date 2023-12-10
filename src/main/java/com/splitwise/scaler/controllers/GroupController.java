package com.splitwise.scaler.controllers;

import com.splitwise.scaler.DTOs.CreateGroupRequestDTO;
import com.splitwise.scaler.DTOs.CreateGroupResponseDTO;
import com.splitwise.scaler.DTOs.ResponseStatus;
import com.splitwise.scaler.exceptions.UserCannotBeFoundException;
import com.splitwise.scaler.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class GroupController {

    @Autowired
    private GroupService groupService;
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }
    public CreateGroupResponseDTO createGroup(CreateGroupRequestDTO createGroupRequestDTO) {
        CreateGroupResponseDTO createGroupResponseDTO = new CreateGroupResponseDTO();
        try {
            groupService.createNewGroup(createGroupRequestDTO.getGroupName(), createGroupRequestDTO.getUserId());
        }
        catch(UserCannotBeFoundException userCannotBeFoundException) {
            createGroupResponseDTO.setResponseStatus(ResponseStatus.FAILED);
            System.out.println("The user Id provided is not in our database");
        }
        createGroupResponseDTO.setResponseStatus(ResponseStatus.SUCCESSFUL);
        return createGroupResponseDTO;
    }
}
