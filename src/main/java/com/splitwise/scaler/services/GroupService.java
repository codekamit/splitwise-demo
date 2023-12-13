package com.scaler.splitwise.services;

import com.scaler.splitwise.exceptions.GroupCannotBeFoundException;
import com.scaler.splitwise.exceptions.UserCannotBeFoundException;
import com.scaler.splitwise.models.Group;
import com.scaler.splitwise.models.User;
import com.scaler.splitwise.repositories.GroupRepository;
import com.scaler.splitwise.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class GroupService {
    private GroupRepository groupRepository;
    private UserRepository userRepository;
    public GroupService(GroupRepository groupRepository, UserRepository userRepository) {
        this.groupRepository = groupRepository;
        this.userRepository = userRepository;
    }
    public void createNewGroup(String groupName, Long userId) throws UserCannotBeFoundException {
        Group group = new Group();
        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isEmpty()) {
            throw new UserCannotBeFoundException();
        }
        User groupAdmin = userOptional.get();
        group.setGroupName(groupName);
        group.setGroupAdmin(groupAdmin);
        group.setGroupExpenses(new ArrayList<>());
        group.setGroupParticipants(new ArrayList<>());
        group.getGroupParticipants().add(groupAdmin);
        groupRepository.save(group);
    }

    public Group getGroup(Long groupId) throws GroupCannotBeFoundException {
        Optional<Group> groupOptional = groupRepository.findById(groupId);
        if(groupOptional.isEmpty()) {
            throw new GroupCannotBeFoundException();
        }
        return groupOptional.get();
    }
}
