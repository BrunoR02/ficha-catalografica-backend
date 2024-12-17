package com.ficha.catalografica.projeto.cataloging.infrastructure.record.database.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.ficha.catalografica.projeto.cataloging.infrastructure.record.database.embeddable.BookMetadataEmbeddable;
import com.ficha.catalografica.projeto.cataloging.infrastructure.record.database.embeddable.PublishingDataEmbeddable;
import com.ficha.catalografica.projeto.cataloging.infrastructure.record.database.embeddable.RecordClassificationEmbeddable;
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
@Table(name = "catalog_records")
@SecondaryTables({
    @SecondaryTable(name = "cr_work_metadata", pkJoinColumns = @PrimaryKeyJoinColumn(referencedColumnName = "catalog_record_id")),
    @SecondaryTable(name = "cr_publishing_data", pkJoinColumns = @PrimaryKeyJoinColumn(referencedColumnName = "catalog_record_id")),
    @SecondaryTable(name = "cr_book_metadata", pkJoinColumns = @PrimaryKeyJoinColumn(referencedColumnName = "catalog_record_id")),
    @SecondaryTable(name = "cr_record_classification", pkJoinColumns = @PrimaryKeyJoinColumn(referencedColumnName = "catalog_record_id")),
})
public class CatalogRecordEntity {

  @Id
  private String id;

  @Column(name = "creator_id")
  private String creatorId;

  private List<String> responsabilities;

  @Embedded
  private WorkMetadataEmbeddable workMetadata;

  private String translator;

  @Embedded
  private PublishingDataEmbeddable publishingData;

  @Column(name = "publisher_name")
  private String publisherName;

  @Embedded
  private BookMetadataEmbeddable bookMetadata;

  private List<String> notes;

  @Column(name = "secondary_subjects")
  private List<String> secondarySubjects;

  @Embedded
  private RecordClassificationEmbeddable classification;

  @Column(name = "created_at")
  private LocalDateTime createdAt;

}
