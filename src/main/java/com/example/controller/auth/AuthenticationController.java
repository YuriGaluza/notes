package com.example.controller.auth;

import com.example.dto.request.AuthenticationDtoRequest;
import com.example.dto.request.RegisterDtoRequest;
import com.example.dto.response.AuthenticationDtoResponse;
import com.example.service.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {

  private final AuthenticationService service;

  public AuthenticationController(AuthenticationService service) {
    this.service = service;
  }

  @PostMapping("/register")
  public ResponseEntity<AuthenticationDtoResponse> register(@RequestBody RegisterDtoRequest request) {
    return ResponseEntity.ok(service.register(request));
  }

  @PostMapping("/authenticate")
  public ResponseEntity<AuthenticationDtoResponse> authenticate(@RequestBody AuthenticationDtoRequest request) {
    return ResponseEntity.ok(service.authenticate(request));
  }
}
