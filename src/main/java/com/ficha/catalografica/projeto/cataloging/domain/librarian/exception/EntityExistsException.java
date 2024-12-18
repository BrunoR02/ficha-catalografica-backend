package com.ficha.catalografica.projeto.cataloging.domain.librarian.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Getter;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
@Getter
public class EntityExistsException extends RuntimeException {

  private final String title = "Entity Exists Exception";

  private final HttpStatus statusCode = HttpStatus.BAD_REQUEST;

  public EntityExistsException(String message) {
    super(message);
  }
}
