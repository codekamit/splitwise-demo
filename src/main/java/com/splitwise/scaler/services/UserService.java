package com.splitwise.scaler.services;

import com.splitwise.scaler.exceptions.UserCannotBeFoundException;
import com.splitwise.scaler.models.User;
import com.splitwise.scaler.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public void registerUser(String firstName, String lastName, String email, String password) {
        User newUser = new User();
        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);
        newUser.setEmailId(email);
        newUser.setPassword(password);
        userRepository.save(newUser);
    }

    public User getUser(Long userId) throws UserCannotBeFoundException {
        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isEmpty()) {
            throw new UserCannotBeFoundException();
        }
        return userOptional.get();
    }
}
