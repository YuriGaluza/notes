package com.home.notes.service;

import com.home.notes.dto.response.UserDtoResponse;
import com.home.notes.model.User;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserService {
    private Map<String, User> userMap = new HashMap<>();

    public User addUser(UserDtoResponse userDtoResponse) {
        User user = new User(userDtoResponse.getFirstName(), userDtoResponse.getLastName());
        return userMap.put(user.getFirstName(), user);
    }

    public UserDtoResponse getUserByName(String firstName) throws Exception {
        if (userMap.isEmpty()) {
            throw new Exception("Пользователя с именем " + firstName + " нет в базе");
        }
        User user = userMap.get(firstName);
        return new UserDtoResponse(user.getFirstName(), user.getLastName());
    }
}
