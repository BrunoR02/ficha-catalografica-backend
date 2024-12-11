package com.ficha.catalografica.projeto.librarian.domain.librarian.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Getter;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
@Getter
public class AlreadyExistsException extends RuntimeException {

  private final HttpStatus statusCode = HttpStatus.BAD_REQUEST;

  public AlreadyExistsException(String message) {
    super(message);
  }
}
