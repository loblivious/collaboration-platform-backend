package com.loblivious.collaborationplatform.services.impl;

import com.loblivious.collaborationplatform.entities.User;
import com.loblivious.collaborationplatform.models.RegisterRequestDTO;
import com.loblivious.collaborationplatform.repositories.UserRepository;
import com.loblivious.collaborationplatform.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  @Override
  public User registerUser(RegisterRequestDTO registerRequestDTO) {
    // Check if user already exists
    if (userRepository.findByEmail(registerRequestDTO.email()).isPresent()) {
      throw new IllegalArgumentException("Email already exists");
    }

    // Create a new user
    User user = new User();
    user.setUsername(registerRequestDTO.username());
    user.setEmail(registerRequestDTO.email());

    // Encode the password before saving
    user.setPasswordHash(passwordEncoder.encode(registerRequestDTO.password()));
    return userRepository.save(user);
  }
}
