package com.ficha.catalografica.projeto.cataloging.infrastructure.record.database.mapper;

import com.ficha.catalografica.projeto.cataloging.domain.librarian.valueobject.LibrarianId;
import com.ficha.catalografica.projeto.cataloging.domain.record.model.UniversityCatalogRecord;
import com.ficha.catalografica.projeto.cataloging.infrastructure.record.database.entity.UniversityCatalogRecordEntity;

public class UniversityCatalogRecordEntityMapper {

  public static UniversityCatalogRecord toDomain(UniversityCatalogRecordEntity entity) {
    return UniversityCatalogRecord.builder()
        .creatorId(new LibrarianId(entity.getCreatorId()))
        .responsabilities(entity.getResponsabilities())
        .workMetadata(WorkMetadataEmbeddableMapper.toDomain(entity.getWorkMetadata()))
        .advisor(entity.getAdvisor())
        .publishingData(PublishingDataEmbeddableMapper.toDomain(entity.getPublishingData()))
        .universityWorkMetadata(UniversityWorkMetadataEmbeddableMapper.toDomain(entity.getUniversityWorkMetadata()))
        .secondarySubjects(entity.getSecondarySubjects())
        .classification(RecordClassificationEmbeddableMapper.toDomain(entity.getClassification()))
        .build();
  }

  public static UniversityCatalogRecordEntity toEntity(UniversityCatalogRecord universityCatalogRecord) {
    return UniversityCatalogRecordEntity.builder()
        .id(universityCatalogRecord.getId().getValue())
        .creatorId(universityCatalogRecord.getCreatorId().getValue())
        .responsabilities(universityCatalogRecord.getResponsabilities())
        .workMetadata(WorkMetadataEmbeddableMapper.toEmbeddable(universityCatalogRecord.getWorkMetadata()))
        .advisor(universityCatalogRecord.getAdvisor())
        .publishingData(PublishingDataEmbeddableMapper.toEmbeddable(universityCatalogRecord.getPublishingData()))
        .universityWorkMetadata(UniversityWorkMetadataEmbeddableMapper.toEmbeddable(universityCatalogRecord.getUniversityWorkMetadata()))
        .secondarySubjects(universityCatalogRecord.getSecondarySubjects())
        .classification(RecordClassificationEmbeddableMapper.toEmbeddable(universityCatalogRecord.getClassification()))
        .createdAt(universityCatalogRecord.getCreatedAt())
        .build();
  }

}
