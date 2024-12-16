package com.ficha.catalografica.projeto.cataloging.domain.librarian.valueobject;

import lombok.Getter;

@Getter
public enum Sex {
  MALE("male"), FEMININE("female");

  private final String value;

  Sex(String value) {
    this.value = value;
  }

  public static Sex parse(String value) throws IllegalArgumentException {
    for (Sex sex : Sex.values()) {
      if (sex.value.equals(value))
        return sex;
    }

    throw new IllegalArgumentException("Invalid value for Sex. Only permitted: 'male', 'female'");
  }

}
