package com.ficha.catalografica.projeto.cataloging.domain.record.valueobject;

import io.micrometer.common.util.StringUtils;
import lombok.Getter;

@Getter
public class UniversityWorkMetadata {

  private final UniversityWorkType workType;

  private final String universityName;

  private final String degreeCourse;

  private final String department;

  private final String issn;

  public UniversityWorkMetadata(UniversityWorkType workType, String universityName, String degreeCourse,
      String department,
      String issn) {
    if (workType == null)
      throw new IllegalArgumentException("workType cannot be null");
    if (StringUtils.isBlank(universityName))
      throw new IllegalArgumentException("universityName cannot be null or empty");
    if (StringUtils.isBlank(degreeCourse))
      throw new IllegalArgumentException("degreeCourse cannot be null or empty");
    if (StringUtils.isBlank(department))
      throw new IllegalArgumentException("department cannot be null or empty");

    this.workType = workType;
    this.universityName = universityName;
    this.degreeCourse = degreeCourse;
    this.department = department;
    this.issn = issn;
  }

}
