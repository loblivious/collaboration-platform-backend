package com.loblivious.collaborationplatform.models;

import jakarta.validation.constraints.NotBlank;

public record RegisterRequestDTO(@NotBlank(message = "username is required") String username,
                                 @NotBlank(message = "email is required") String email,
                                 @NotBlank(message = "password is required") String password) {

}
