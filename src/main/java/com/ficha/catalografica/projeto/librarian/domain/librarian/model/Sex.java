package com.ficha.catalografica.projeto.librarian.domain.librarian.model;

import lombok.Getter;

@Getter
public enum Sex {
  MASCULINE("masculino"), FEMININE("feminino");

  private final String value;

  Sex(String value) {
    this.value = value;
  }

  public static Sex parse(String value) {
    for (Sex sex : Sex.values()) {
      if (sex.value.equals(value))
        return sex;
    }

    throw new IllegalArgumentException("Invalid value for sex. Only permitted: 'masculino', 'feminino'");
  }

}
