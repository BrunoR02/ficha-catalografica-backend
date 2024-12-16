package com.ficha.catalografica.projeto.cataloging.domain.librarian.valueobject;

import java.util.regex.Pattern;

import lombok.Getter;

@Getter
public class Email {

  private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");

  private final String value;

  public Email(String email) throws IllegalArgumentException {
    if (email == null || !EMAIL_PATTERN.matcher(email).matches())
      throw new IllegalArgumentException("Email is invalid");

    this.value = email;
  }

}
