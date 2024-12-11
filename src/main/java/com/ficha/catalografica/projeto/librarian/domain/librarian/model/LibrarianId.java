package com.ficha.catalografica.projeto.librarian.domain.librarian.model;

import java.util.UUID;

public class LibrarianId {

  private final String value;

  public LibrarianId() {
    value = UUID.randomUUID().toString();
  }

  public String getValue() {
    return value;
  }

}
