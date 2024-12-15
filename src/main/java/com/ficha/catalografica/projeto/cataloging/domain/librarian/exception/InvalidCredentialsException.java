package com.ficha.catalografica.projeto.cataloging.domain.librarian.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Getter;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
@Getter
public class InvalidCredentialsException extends RuntimeException {

  private final HttpStatus statusCode = HttpStatus.BAD_REQUEST;

  public InvalidCredentialsException(String message) {
    super(message);
  }
}
