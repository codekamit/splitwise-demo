package com.splitwise.scaler.RestController;

import com.splitwise.scaler.DTOs.*;
import com.splitwise.scaler.DTOs.ResponseStatus;
import com.splitwise.scaler.exceptions.GroupCannotBeFoundException;
import com.splitwise.scaler.exceptions.UserCannotBeFoundException;
import com.splitwise.scaler.models.Group;
import com.splitwise.scaler.models.User;
import com.splitwise.scaler.services.GroupService;
import com.splitwise.scaler.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/_api")
public class GroupRESTController {

    @Autowired
    private GroupService groupService;

    @Autowired
    private UserService userService;

    @PostMapping(value="/group")
    public @ResponseBody ResponseEntity<CreateGroupResponseDTO> addGroup(@RequestBody CreateGroupRequestDTO createGroupRequestDTO) {
        User user = userService.getUser(createGroupRequestDTO.getUserId());
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

    @GetMapping("group/{id}")
    public GetGroupResponseDTO getGroup(@PathVariable Long id) throws GroupCannotBeFoundException {
        Group group = groupService.getGroup(id);
        GetGroupResponseDTO getGroupResponseDTO = new GetGroupResponseDTO();
        getGroupResponseDTO.setId(id);
        getGroupResponseDTO.setGroupName(group.getGroupName());
        getGroupResponseDTO.setNoOfUsers(group.getGroupParticipants().size());
        return getGroupResponseDTO;
    }


}
