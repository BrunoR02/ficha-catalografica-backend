package com.ficha.catalografica.projeto.cataloging.domain.record.valueobject;

import io.micrometer.common.util.StringUtils;
import lombok.Getter;

@Getter
public class RecordClassification {

  private final String cdd;

  private final String cdu;

  private final String cutter;

  public RecordClassification(String cdd, String cdu, String cutter) {
    if (StringUtils.isBlank(cdd) && StringUtils.isBlank(cdu))
      throw new IllegalArgumentException("cdd or cdu is required");
    if (StringUtils.isBlank(cutter))
      throw new IllegalArgumentException("cutter cannot be null or empty");

    this.cdd = cdd;
    this.cdu = cdu;
    this.cutter = cutter;
  }

}
