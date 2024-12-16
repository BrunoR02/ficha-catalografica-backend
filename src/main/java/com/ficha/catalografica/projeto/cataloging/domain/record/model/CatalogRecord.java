package com.ficha.catalografica.projeto.cataloging.domain.record.model;

import java.time.LocalDateTime;
import java.util.List;

import com.ficha.catalografica.projeto.cataloging.domain.librarian.valueobject.LibrarianId;
import com.ficha.catalografica.projeto.cataloging.domain.record.valueobject.BookMetadata;
import com.ficha.catalografica.projeto.cataloging.domain.record.valueobject.CatalogRecordId;
import com.ficha.catalografica.projeto.cataloging.domain.record.valueobject.PublishingData;
import com.ficha.catalografica.projeto.cataloging.domain.record.valueobject.RecordClassification;
import com.ficha.catalografica.projeto.cataloging.domain.record.valueobject.WorkMetadata;

import io.micrometer.common.util.StringUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class CatalogRecord {

  private CatalogRecordId id;

  private LibrarianId creatorId;

  private List<String> responsabilities;

  private WorkMetadata workMetadata;

  private String translator;

  private PublishingData publishingData;

  private String publisherName;

  private BookMetadata bookMetadata;

  private List<String> notes;

  private List<String> secondarySubjects;

  private RecordClassification classification;

  private LocalDateTime createdAt;

  public CatalogRecord(LibrarianId creatorId, List<String> responsabilities,
      WorkMetadata workMetadata, String translator, PublishingData publishingData, String publisherName,
      BookMetadata bookMetadata, List<String> notes, List<String> secondarySubjects,
      RecordClassification classification) {
    if (creatorId == null)
      throw new IllegalArgumentException("creatorId cannot be null");
    if (responsabilities == null || responsabilities.size() == 0)
      throw new IllegalArgumentException("At least one responsability is required");
    if (workMetadata == null)
      throw new IllegalArgumentException("workMetadata cannot be null");
    if (publishingData == null)
      throw new IllegalArgumentException("publishingData cannot be null");
    if (StringUtils.isBlank(publisherName))
      throw new IllegalArgumentException("publisherName cannot be null or empty");
    if (bookMetadata == null)
      throw new IllegalArgumentException("bookMetadata cannot be null");
    if (secondarySubjects == null || secondarySubjects.size() == 0)
      throw new IllegalArgumentException("At least one secondarySubject is required");
    if (classification == null)
      throw new IllegalArgumentException("classification cannot be null");

    this.id = new CatalogRecordId();
    this.createdAt = LocalDateTime.now();
    this.creatorId = creatorId;
    this.responsabilities = responsabilities;
    this.workMetadata = workMetadata;
    this.translator = translator;
    this.publishingData = publishingData;
    this.publisherName = publisherName;
    this.bookMetadata = bookMetadata;
    this.notes = notes;
    this.secondarySubjects = secondarySubjects;
    this.classification = classification;
  }

}
