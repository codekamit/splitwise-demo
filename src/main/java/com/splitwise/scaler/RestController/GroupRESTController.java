package com.splitwise.scaler.RestController;

import com.splitwise.scaler.DTOs.CreateGroupRequestDTO;
import com.splitwise.scaler.DTOs.CreateGroupResponseDTO;
import com.splitwise.scaler.DTOs.ResponseStatus;
import com.splitwise.scaler.exceptions.UserCannotBeFoundException;
import com.splitwise.scaler.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/group")
public class GroupRESTController {

    @Autowired
    private SettleUpService settleUpService;

    @Autowired
    private GroupService groupService;

    @PostMapping(value="/add")
    public @ResponseBody ResponseEntity<CreateGroupResponseDTO> addGroup(@RequestBody CreateGroupRequestDTO createGroupRequestDTO) {
        CreateGroupResponseDTO createGroupResponseDTO = new CreateGroupResponseDTO();
        try {
            groupService.createNewGroup(createGroupRequestDTO.getGroupName(), createGroupRequestDTO.getUserId());
            createGroupResponseDTO.setResponseStatus(ResponseStatus.SUCCESSFUL);
            createGroupResponseDTO.setMessage("Group created successfully");
            return ResponseEntity.status(HttpStatus.CREATED).body(createGroupResponseDTO);
        }
        catch(UserCannotBeFoundException userCannotBeFoundException) {
            createGroupResponseDTO.setResponseStatus(ResponseStatus.FAILED);
            createGroupResponseDTO.setMessage("Failed to create group.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(createGroupResponseDTO);
        }
    }


}
