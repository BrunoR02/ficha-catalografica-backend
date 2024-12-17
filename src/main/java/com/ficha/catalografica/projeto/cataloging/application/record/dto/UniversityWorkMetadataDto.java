package com.ficha.catalografica.projeto.cataloging.application.record.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UniversityWorkMetadataDto {

  private String workType;

  private String universityName;

  private String degreeCourse;

  private String department;

  private String issn;
}
