package com.ficha.catalografica.projeto.cataloging.domain.librarian.valueobject;

import java.util.UUID;

import lombok.Getter;

@Getter
public class LibrarianId {

  private final String value;

  public LibrarianId() {
    value = UUID.randomUUID().toString();
  }

  public LibrarianId(String value) {
    this.value = value;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((value == null) ? 0 : value.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    LibrarianId other = (LibrarianId) obj;
    if (value == null) {
      if (other.value != null)
        return false;
    } else if (!value.equals(other.value))
      return false;
    return true;
  }

}
