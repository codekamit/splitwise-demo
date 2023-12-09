package com.splitwise.scaler.services;

import com.splitwise.scaler.exceptions.UserCannotBeFoundException;
import com.splitwise.scaler.models_myself.User;
import com.splitwise.scaler.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;
    public User registerUser(String firstName, String lastName, String email, String password) {
        return null;
    }

    public User getUser(Long userId) throws UserCannotBeFoundException {
        Optional<User> userOptional = userRepository.findById(userId);
        if(userOptional.isEmpty()) {
            throw new UserCannotBeFoundException();
        }
        return userOptional.get();
    }
}
