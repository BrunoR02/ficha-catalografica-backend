package com.ficha.catalografica.projeto.cataloging.domain.librarian.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Getter;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
@Getter
public class InvalidCredentialsException extends RuntimeException {

  private final String title = "Invalid Credentials Exception";

  private final HttpStatus statusCode = HttpStatus.UNAUTHORIZED;

  public InvalidCredentialsException(String message) {
    super(message);
  }
}
