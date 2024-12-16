package com.ficha.catalografica.projeto.cataloging.domain.record.valueobject;

import io.micrometer.common.util.StringUtils;
import lombok.Getter;

@Getter
public class PublishingData {

  private final String date;

  private final String location;

  public PublishingData(String date, String location) {
    if (StringUtils.isBlank(date))
      throw new IllegalArgumentException("date cannot be null or empty");
    if (StringUtils.isBlank(location))
      throw new IllegalArgumentException("location cannot be null or empty");

    this.date = date;
    this.location = location;
  }

}
