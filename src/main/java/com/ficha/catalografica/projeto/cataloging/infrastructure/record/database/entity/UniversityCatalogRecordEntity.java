package com.ficha.catalografica.projeto.cataloging.infrastructure.record.database.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.ficha.catalografica.projeto.cataloging.infrastructure.record.database.embeddable.PublishingDataEmbeddable;
import com.ficha.catalografica.projeto.cataloging.infrastructure.record.database.embeddable.RecordClassificationEmbeddable;
import com.ficha.catalografica.projeto.cataloging.infrastructure.record.database.embeddable.UniversityWorkMetadataEmbeddable;
import com.ficha.catalografica.projeto.cataloging.infrastructure.record.database.embeddable.WorkMetadataEmbeddable;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.SecondaryTable;
import jakarta.persistence.SecondaryTables;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
@Entity
@Table(name = "university_catalog_record")
@SecondaryTables({
    @SecondaryTable(name = "cr_work_metadata", pkJoinColumns = @PrimaryKeyJoinColumn(referencedColumnName = "catalog_record_id")),
    @SecondaryTable(name = "cr_publishing_data", pkJoinColumns = @PrimaryKeyJoinColumn(referencedColumnName = "catalog_record_id")),
    @SecondaryTable(name = "cr_university_work_metadata", pkJoinColumns = @PrimaryKeyJoinColumn(referencedColumnName = "catalog_record_id")),
    @SecondaryTable(name = "cr_record_classification", pkJoinColumns = @PrimaryKeyJoinColumn(referencedColumnName = "catalog_record_id")),
})
public class UniversityCatalogRecordEntity {

  @Id
  private String id;

  @Column(name = "creator_id")
  private String creatorId;

  private List<String> responsabilities;

  @Embedded
  private WorkMetadataEmbeddable workMetadata;

  private String advisor;

  @Embedded
  private UniversityWorkMetadataEmbeddable universityWorkMetadata;

  @Embedded
  private PublishingDataEmbeddable publishingData;

  @Column(name = "secondary_subjects")
  private List<String> secondarySubjects;

  @Embedded
  private RecordClassificationEmbeddable classification;

  @Column(name = "created_at")
  private LocalDateTime createdAt;

}
