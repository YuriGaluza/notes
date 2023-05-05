package com.example.controller;

import com.example.dto.request.TokenDtoRequest;
import com.example.service.AuthenticationService;
import com.example.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/notes")
public class NoteController {
    private final AuthenticationService service;
    private final UserService userService;

    public NoteController(AuthenticationService service, UserService userService) {
        this.service = service;
        this.userService = userService;
    }

    @GetMapping("/hello")
    public ResponseEntity<String> sayHello(@RequestBody TokenDtoRequest token) {
        return ResponseEntity.ok(token.getToken());
    }
}
