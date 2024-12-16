package com.ficha.catalografica.projeto.cataloging.domain.record.valueobject;

import io.micrometer.common.util.StringUtils;
import lombok.Getter;

@Getter
public class ISBN {

  private final String value;

  public ISBN(String value) {
    if (StringUtils.isBlank(value))
      throw new IllegalArgumentException("isbn value cannot be null or empty");
    if (!value.matches("\\d+"))
      throw new IllegalArgumentException("isbn have invalid characters. Only number is permitted");
    if (value.length() != 10 && value.length() != 13)
      throw new IllegalArgumentException("isbn length have to be 10 or 13");

    this.value = value;
  }

}
