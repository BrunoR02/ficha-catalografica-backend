package com.ficha.catalografica.projeto.cataloging.infrastructure.record.database.embeddable;

import com.ficha.catalografica.projeto.cataloging.domain.record.valueobject.UniversityWorkType;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
@Embeddable
public class UniversityWorkMetadataEmbeddable {

  @Enumerated(EnumType.STRING)
  @Column(name = "work_type", table = "cr_university_work_metadata")
  private UniversityWorkType workType;

  @Column(name = "university_name", table = "cr_university_work_metadata")
  private String universityName;

  @Column(name = "degree_course", table = "cr_university_work_metadata")
  private String degreeCourse;

  private String department;

  private String issn;

}
