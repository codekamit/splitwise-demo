package com.splitwise.scaler.services;

import com.splitwise.scaler.exceptions.GroupCannotBeFoundException;
import com.splitwise.scaler.exceptions.UserCannotBeFoundException;
import com.splitwise.scaler.models.Group;
import com.splitwise.scaler.models.User;
import com.splitwise.scaler.repositories.GroupRepository;
import com.splitwise.scaler.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
