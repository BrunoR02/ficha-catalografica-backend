package com.ficha.catalografica.projeto.cataloging.infrastructure.record.database.mapper;

import com.ficha.catalografica.projeto.cataloging.domain.librarian.valueobject.LibrarianId;
import com.ficha.catalografica.projeto.cataloging.domain.record.model.CatalogRecord;
import com.ficha.catalografica.projeto.cataloging.infrastructure.record.database.entity.CatalogRecordEntity;

public class CatalogRecordEntityMapper {

  public static CatalogRecord toDomain(CatalogRecordEntity entity) {
    return CatalogRecord.builder()
        .creatorId(new LibrarianId(entity.getCreatorId()))
        .responsabilities(entity.getResponsabilities())
        .workMetadata(WorkMetadataEmbeddableMapper.toDomain(entity.getWorkMetadata()))
        .translator(entity.getTranslator())
        .publishingData(PublishingDataEmbeddableMapper.toDomain(entity.getPublishingData()))
        .publisherName(entity.getPublisherName())
        .bookMetadata(BookMetadataEmbeddableMapper.toDomain(entity.getBookMetadata()))
        .notes(entity.getNotes())
        .secondarySubjects(entity.getSecondarySubjects())
        .classification(RecordClassificationEmbeddableMapper.toDomain(entity.getClassification()))
        .build();
  }

  public static CatalogRecordEntity toEntity(CatalogRecord catalogRecord) {
    return CatalogRecordEntity.builder()
        .id(catalogRecord.getId().getValue())
        .creatorId(catalogRecord.getCreatorId().getValue())
        .responsabilities(catalogRecord.getResponsabilities())
        .workMetadata(WorkMetadataEmbeddableMapper.toEmbeddable(catalogRecord.getWorkMetadata()))
        .translator(catalogRecord.getTranslator())
        .publishingData(PublishingDataEmbeddableMapper.toEmbeddable(catalogRecord.getPublishingData()))
        .publisherName(catalogRecord.getPublisherName())
        .bookMetadata(BookMetadataEmbeddableMapper.toEmbeddable(catalogRecord.getBookMetadata()))
        .notes(catalogRecord.getNotes())
        .secondarySubjects(catalogRecord.getSecondarySubjects())
        .classification(RecordClassificationEmbeddableMapper.toEmbeddable(catalogRecord.getClassification()))
        .createdAt(catalogRecord.getCreatedAt())
        .build();
  }

}
