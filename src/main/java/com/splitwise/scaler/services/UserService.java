package com.splitwise.scaler.services;

import com.splitwise.scaler.exceptions.UserCannotBeFoundException;
import com.splitwise.scaler.models.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    private ServiceUtils serviceUtils;

    @Transactional
    public void registerUser(String firstName, String lastName, String email, String password) {
        User newUser = new User();
        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);
        newUser.setEmailId(email);
        newUser.setPassword(password);
        serviceUtils.getUserRepository().save(newUser);
    }

    @Transactional
    public User getUser(Long userId) throws UserCannotBeFoundException {
        return serviceUtils.getUserFromRepository(userId);
    }
}
