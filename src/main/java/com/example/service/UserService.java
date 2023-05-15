package com.example.service;

import com.example.exception.UserNotFoundException;
import com.example.model.User;
import com.example.repository.TokenRepository;
import com.example.repository.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository repository, TokenRepository tokenRepository) {
        this.userRepository = repository;
    }

    public UserDetails getUserDetails() {
        return (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    public boolean addToIgnore(User ignoreUser) throws Exception {
        User currentUser = getCurrentUser();
        boolean isAddedToIgnore = currentUser.getIgnore().add(ignoreUser);
        if (isAddedToIgnore) {
            userRepository.save(currentUser);
        }
        return isAddedToIgnore;
    }

    public boolean addToFollowing(User followUser) throws Exception {
        User currentUser = getCurrentUser();
        boolean isAddedToFollowing = currentUser.getFollowing().add(followUser);
        if (isAddedToFollowing) {
            userRepository.save(currentUser);
        }
        return isAddedToFollowing;
    }

    public User getCurrentUser() throws UserNotFoundException {
        User currentUser = userRepository.findByLogin(getUserDetails().getUsername()).orElse(null);
        if (currentUser == null) {
            throw new UserNotFoundException("User is not found");
        }
        return currentUser;
    }
}
