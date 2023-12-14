package com.splitwise.scaler.services;

import com.splitwise.scaler.exceptions.GroupCannotBeFoundException;
import com.splitwise.scaler.exceptions.InvalidAdminException;
import com.splitwise.scaler.exceptions.UserCannotBeFoundException;
import com.splitwise.scaler.models.Group;
import com.splitwise.scaler.models.User;
import com.splitwise.scaler.repositories.GroupRepository;
import com.splitwise.scaler.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class GroupService {

    @Autowired
    private ServiceUtils serviceUtils;

    @Transactional
    public void createNewGroup(String groupName, Long userId) throws UserCannotBeFoundException {
        Group group = new Group();
        User groupAdmin = serviceUtils.getUserFromRepository(userId);
        group.setGroupName(groupName);
        group.setGroupAdmin(groupAdmin);
        group.setGroupExpenses(new ArrayList<>());
        group.setGroupParticipants(new ArrayList<>());
        group.getGroupParticipants().add(groupAdmin);
        serviceUtils.getGroupRepository().save(group);
    }

    @Transactional
    public Group getGroup(Long groupId) {
        return serviceUtils.getGroupFromRepository(groupId);
    }

    @Transactional
    public void addToGroup(List<Long> userIds, Long groupId, Long AdminId) {
        List<User> newUsersToAdd = userIds.stream().map(userId -> serviceUtils.getUserFromRepository(userId)).toList();
        User groupAdmin = serviceUtils.getUserFromRepository(AdminId);
        Group group = serviceUtils.getGroupFromRepository(groupId);
        if(!group.getGroupAdmin().equals(groupAdmin)) {
            throw new InvalidAdminException();
        }

        Set<User> existingGroupParticipants = new HashSet<>(group.getGroupParticipants());
        newUsersToAdd.stream()
                .filter(user -> !existingGroupParticipants.contains(user))
                .forEach(filteredUser -> group.getGroupParticipants().add(filteredUser));

        serviceUtils.getGroupRepository().save(group);
    }

    @Transactional
    public List<User> getGroupMembers(Long groupId) {
        Group group = serviceUtils.getGroupFromRepository(groupId);
        return group.getGroupParticipants();
    }


}
