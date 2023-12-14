package com.splitwise.scaler.services;

import com.splitwise.scaler.exceptions.GroupCannotBeFoundException;
import com.splitwise.scaler.exceptions.UserCannotBeFoundException;
import com.splitwise.scaler.models.Group;
import com.splitwise.scaler.models.User;
import com.splitwise.scaler.repositories.GroupRepository;
import com.splitwise.scaler.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Component
@Getter
@Setter
public class ServiceUtils {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private GroupRepository groupRepository;

    @Transactional
    public User getUserFromRepository(long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isEmpty()) {
            throw new UserCannotBeFoundException();
        }
        return userOptional.get();
    }

    @Transactional
    public Group getGroupFromRepository(long groupId) {
        Optional<Group> groupOptional = groupRepository.findById(groupId);
        if(groupOptional.isEmpty()) {
            throw new GroupCannotBeFoundException();
        }
        return groupOptional.get();
    }
}
