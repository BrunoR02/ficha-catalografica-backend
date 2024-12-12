package com.ficha.catalografica.projeto.librarian.application.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class LoginLibrarianResponse {

  private String accessToken;

  private long expiresAt;
  
}
