package com.ficha.catalografica.projeto.librarian.domain.librarian.model;

import java.time.LocalDate;

import lombok.Getter;

@Getter
public class LibrarianInfo {

  private final String fullName;

  private final Sex sex;

  private final LocalDate birthDate;

  public LibrarianInfo(String fullName, Sex sex, LocalDate birthDate) throws IllegalArgumentException {
    if(fullName == null)
      throw new IllegalArgumentException("fullName cannot be null");
    if(sex == null)
      throw new IllegalArgumentException("sex cannot be null");
    if(birthDate == null)
      throw new IllegalArgumentException("birthDate cannot be null");

    this.fullName = fullName;
    this.sex = sex;
    this.birthDate = birthDate;
  }

}
