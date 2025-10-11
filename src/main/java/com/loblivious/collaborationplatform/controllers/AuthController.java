package com.loblivious.collaborationplatform.controllers;

import com.loblivious.collaborationplatform.entities.User;
import com.loblivious.collaborationplatform.models.RegisterRequestDTO;
import com.loblivious.collaborationplatform.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

  private final AuthService authService;

  @PostMapping("/register")
  public ResponseEntity<User> registerUser(@RequestBody RegisterRequestDTO registerRequestDTO) {
    User registerUser = authService.registerUser(registerRequestDTO);
    return new ResponseEntity<>(registerUser, HttpStatus.CREATED);
  }
}
