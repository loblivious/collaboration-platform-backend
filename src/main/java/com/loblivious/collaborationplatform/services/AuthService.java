package com.loblivious.collaborationplatform.services;

import com.loblivious.collaborationplatform.entities.User;
import com.loblivious.collaborationplatform.models.RegisterRequestDTO;

public interface AuthService {

  User registerUser(RegisterRequestDTO registerRequestDTOF);
}
