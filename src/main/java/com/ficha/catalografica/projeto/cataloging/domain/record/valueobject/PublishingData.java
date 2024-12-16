package com.ficha.catalografica.projeto.cataloging.domain.record.valueobject;

import java.time.LocalDate;

import io.micrometer.common.util.StringUtils;
import lombok.Getter;

@Getter
public class PublishingData {

  private final LocalDate date;

  private final String location;

  public PublishingData(LocalDate date, String location) {
    if (date == null)
      throw new IllegalArgumentException("date cannot be null");
    if (StringUtils.isBlank(location))
      throw new IllegalArgumentException("location cannot be null or empty");

    this.date = date;
    this.location = location;
  }

}
