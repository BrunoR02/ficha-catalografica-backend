package com.ficha.catalografica.projeto.cataloging.domain.record.valueobject;

public enum UniversityWorkType {
  GRADUATION("graduation"), SPECIALIZATION("specialization"), MASTER("master"), DOCTORATE("doctorate");

  private final String value;

  UniversityWorkType(String value) {
    this.value = value;
  }

  public static UniversityWorkType parse(String value) throws IllegalArgumentException {
    for (UniversityWorkType sex : UniversityWorkType.values()) {
      if (sex.value.equals(value))
        return sex;
    }

    throw new IllegalArgumentException(
        "Invalid value for universityWorkType. Only permitted: 'graduation', 'specialization', 'master', 'doctorate'");
  }

}
