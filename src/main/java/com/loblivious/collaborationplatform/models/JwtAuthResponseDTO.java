package com.loblivious.collaborationplatform.models;

public record JwtAuthResponseDTO(String accessToken, String TokenType) {

  public JwtAuthResponseDTO(String accessToken) {
    this(accessToken, "Bearer");
  }

}
