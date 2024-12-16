package com.ficha.catalografica.projeto.cataloging.application.record.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class CatalogRecordDto {

  private String id;

  @JsonProperty(value = "creator_id")
  private String creatorId;

  private List<String> responsabilities;

  @JsonProperty(value = "work_metadata")
  private WorkMetadataDto workMetadata;

  private String translator;

  @JsonProperty(value = "publishing_data")
  private PublishingDataDto publishingData;

  @JsonProperty(value = "publisher_name")
  private String publisherName;

  @JsonProperty(value = "book_metadata")
  private BookMetadataDto bookMetadata;

  private List<String> notes;

  @JsonProperty(value = "secondary_subjects")
  private List<String> secondarySubjects;

  private RecordClassificationDto classification;

  private LocalDateTime createdAt;

}
