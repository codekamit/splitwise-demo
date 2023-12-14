package com.splitwise.scaler.RestController;

import com.splitwise.scaler.DTOs.*;
import com.splitwise.scaler.DTOs.ResponseStatus;
import com.splitwise.scaler.exceptions.GroupCannotBeFoundException;
import com.splitwise.scaler.exceptions.UserCannotBeFoundException;
import com.splitwise.scaler.models.Group;
import com.splitwise.scaler.models.User;
import com.splitwise.scaler.services.GroupService;
import com.splitwise.scaler.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/_api")
public class GroupRESTController {

    @Autowired
    private GroupService groupService;

    @Autowired
    private UserService userService;

    @PostMapping(value="groups")
    public @ResponseBody ResponseEntity<CreateGroupResponseDTO> addGroup(@Valid @RequestBody CreateGroupRequestDTO createGroupRequestDTO) {
        groupService.createNewGroup(createGroupRequestDTO.getGroupName(), createGroupRequestDTO.getUserId());
        CreateGroupResponseDTO createGroupResponseDTO = new CreateGroupResponseDTO();
        createGroupResponseDTO.setResponseStatus(ResponseStatus.SUCCESSFUL);
        createGroupResponseDTO.setMessage("Group created successfully");
        return ResponseEntity.status(HttpStatus.CREATED).body(createGroupResponseDTO);
    }

    @GetMapping("groups/{id}")
    public GetGroupResponseDTO getGroup(@PathVariable Long id) throws GroupCannotBeFoundException {
        Group group = groupService.getGroup(id);
        GetGroupResponseDTO getGroupResponseDTO = new GetGroupResponseDTO();
        getGroupResponseDTO.setId(id);
        getGroupResponseDTO.setGroupName(group.getGroupName());
        getGroupResponseDTO.setNoOfUsers(group.getGroupParticipants().size());
        return getGroupResponseDTO;
    }

    @PostMapping("groups/{groupId}/members")
    public ResponseEntity<ResponseMessage> addMembers(@RequestBody AddMemberRequestDTO addMemberRequestDTO) {
        groupService.addToGroup(addMemberRequestDTO.getUserIds(), addMemberRequestDTO.getGroupId(), addMemberRequestDTO.getAdminId());
        ResponseMessage responseMessage = new ResponseMessage.Builder()
                .TimeStamp(LocalDateTime.now())
                .HttpStatusCode(HttpStatusCode.valueOf(200))
                .HttpStatus(HttpStatus.OK)
                .Message("Members Added successfully.")
                .Path("group/id")
                .build();
        return ResponseEntity.status(HttpStatus.OK).body(responseMessage);
    }

    @GetMapping("/groups/{groupId}/members")
    public ResponseEntity<GetGroupMembersResponseDTO> getGroupMembers(@PathVariable Long groupId) {
        List<User> members = groupService.getGroupMembers(groupId);
        GetGroupMembersResponseDTO getGroupMembersResponseDTO = new GetGroupMembersResponseDTO();
        getGroupMembersResponseDTO.setGroupMembers(members);
        getGroupMembersResponseDTO.setTimeStamp(LocalDateTime.now());
        getGroupMembersResponseDTO.setMessage("Request Successful.");
        return ResponseEntity.status(HttpStatus.OK).body(getGroupMembersResponseDTO);
    }
}
