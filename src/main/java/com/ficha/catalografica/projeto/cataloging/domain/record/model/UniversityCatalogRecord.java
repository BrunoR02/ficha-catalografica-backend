package com.ficha.catalografica.projeto.cataloging.domain.record.model;

import java.time.LocalDateTime;
import java.util.List;

import com.ficha.catalografica.projeto.cataloging.domain.librarian.valueobject.LibrarianId;
import com.ficha.catalografica.projeto.cataloging.domain.record.valueobject.CatalogRecordId;
import com.ficha.catalografica.projeto.cataloging.domain.record.valueobject.PublishingData;
import com.ficha.catalografica.projeto.cataloging.domain.record.valueobject.RecordClassification;
import com.ficha.catalografica.projeto.cataloging.domain.record.valueobject.UniversityWorkMetadata;
import com.ficha.catalografica.projeto.cataloging.domain.record.valueobject.WorkMetadata;

import io.micrometer.common.util.StringUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class UniversityCatalogRecord {

  private CatalogRecordId id;

  private LibrarianId creatorId;

  private List<String> responsabilities;

  private WorkMetadata workMetadata;

  private String advisor;

  private UniversityWorkMetadata universityWorkMetadata;

  private PublishingData publishingData;

  private List<String> secondarySubjects;

  private RecordClassification classification;

  private LocalDateTime createdAt;

  public UniversityCatalogRecord(LibrarianId creatorId, List<String> responsabilities,
      WorkMetadata workMetadata, String advisor, UniversityWorkMetadata universityWorkMetadata,
      PublishingData publishingData, List<String> secondarySubjects, RecordClassification classification) {
    if (creatorId == null)
      throw new IllegalArgumentException("creatorId cannot be null");
    if (responsabilities.size() == 0)
      throw new IllegalArgumentException("At least one responsability is required");
    if (workMetadata == null)
      throw new IllegalArgumentException("workMetadata cannot be null");
    if (StringUtils.isBlank(advisor))
      throw new IllegalArgumentException("advisor cannot be null or empty");
    if (universityWorkMetadata == null)
      throw new IllegalArgumentException("universityWorkMetadata cannot be null");
    if (publishingData == null)
      throw new IllegalArgumentException("publishingData cannot be null");
    if (secondarySubjects.size() == 0)
      throw new IllegalArgumentException("At least one secondarySubject is required");
    if (classification == null)
      throw new IllegalArgumentException("classification cannot be null");

    this.id = new CatalogRecordId();
    this.createdAt = LocalDateTime.now();
    this.creatorId = creatorId;
    this.responsabilities = responsabilities;
    this.workMetadata = workMetadata;
    this.advisor = advisor;
    this.publishingData = publishingData;
    this.secondarySubjects = secondarySubjects;
    this.classification = classification;
  }
}
