package com.home.notes.controller;

import com.home.notes.dto.response.UserDtoResponse;
import com.home.notes.service.UserService;
import org.slf4j.helpers.CheckReturnValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/main")
    public String getMainPage() {
        return "Main page";
    }

    @GetMapping("/{first_name}/{last_name}")
    public UserDtoResponse getUserDtoResponse(@PathVariable("first_name") String firstName,
                                              @PathVariable("last_name") String lastName) {
        return new UserDtoResponse(firstName, lastName);
    }

    @PutMapping("/{first_name}/{last_name}")
    public UserDtoResponse addUser(@PathVariable("first_name") String firstName,
                                   @PathVariable("last_name") String lastName) {
        UserDtoResponse response = new UserDtoResponse(firstName, lastName);
        userService.addUser(response);
        return response;
    }

    @GetMapping("/{first_name}")
    public UserDtoResponse getUserByName(@PathVariable("first_name") String firstName) throws Exception {
        return userService.getUserByName(firstName);
    }
}
