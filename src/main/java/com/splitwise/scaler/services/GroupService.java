package com.splitwise.scaler.services;

import com.splitwise.scaler.exceptions.UserCannotBeFoundException;
import com.splitwise.scaler.models.Group;
import com.splitwise.scaler.models.User;
import com.splitwise.scaler.repositories.GroupRepository;
import com.splitwise.scaler.repositories.UserRepository;
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
        group.setGroupExpenseHistory(new ArrayList<>());
        group.setGroupParticipants(new ArrayList<>());
        userRepository.save(group);
    }
}
