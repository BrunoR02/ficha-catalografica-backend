package com.ficha.catalografica.projeto.librarian.domain.librarian.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class Librarian {

  private final LibrarianId id;

  private final LibrarianInfo librarianInfo;

  private final Email email;

  private final Password password;

  private LocalDate registeredAt;

  private LocalDate updatedAt;

  private final String crb;

  public Librarian(LibrarianInfo librarianInfo, Email email, Password password, String crb) throws IllegalArgumentException {
    if (librarianInfo == null)
      throw new IllegalArgumentException("LibrarianInfo cannot be null");
    if (crb == null)
      throw new IllegalArgumentException("crb cannot be null");

    this.id = new LibrarianId();
    this.librarianInfo = librarianInfo;
    this.email = email;
    this.password = password;
    this.registeredAt = LocalDate.now();
    this.updatedAt = LocalDate.now();
    this.crb = crb;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Librarian other = (Librarian) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    return true;
  }

  
}
