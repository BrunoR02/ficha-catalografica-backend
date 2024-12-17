package com.ficha.catalografica.projeto.cataloging.application.record.mapper;

import com.ficha.catalografica.projeto.cataloging.application.record.command.CreateUniversityCatalogRecordCommand;
import com.ficha.catalografica.projeto.cataloging.application.record.dto.UniversityCatalogRecordDto;
import com.ficha.catalografica.projeto.cataloging.domain.librarian.valueobject.LibrarianId;
import com.ficha.catalografica.projeto.cataloging.domain.record.model.UniversityCatalogRecord;

public class UniversityCatalogRecordMapper {

  public static UniversityCatalogRecord toDomain(CreateUniversityCatalogRecordCommand command) {
    return UniversityCatalogRecord.builder()
        .creatorId(new LibrarianId(command.getCreatorId()))
        .responsabilities(command.getResponsabilities())
        .workMetadata(WorkMetadataMapper.toDomain(command.getWorkMetadata()))
        .advisor(command.getAdvisor())
        .publishingData(PublishingDataMapper.toDomain(command.getPublishingData()))
        .universityWorkMetadata(UniversityWorkMetadataMapper.toDomain(command.getUniversityWorkMetadata()))
        .secondarySubjects(command.getSecondarySubjects())
        .classification(RecordClassificationMapper.toDomain(command.getClassification()))
        .build();
  }

  public static UniversityCatalogRecordDto toDto(UniversityCatalogRecord universityCatalogRecord) {
    return UniversityCatalogRecordDto.builder()
        .id(universityCatalogRecord.getId().getValue())
        .creatorId(universityCatalogRecord.getCreatorId().getValue())
        .responsabilities(universityCatalogRecord.getResponsabilities())
        .workMetadata(WorkMetadataMapper.toDto(universityCatalogRecord.getWorkMetadata()))
        .advisor(universityCatalogRecord.getAdvisor())
        .publishingData(PublishingDataMapper.toDto(universityCatalogRecord.getPublishingData()))
        .universityWorkMetadata(UniversityWorkMetadataMapper.toDto(universityCatalogRecord.getUniversityWorkMetadata()))
        .secondarySubjects(universityCatalogRecord.getSecondarySubjects())
        .classification(RecordClassificationMapper.toDto(universityCatalogRecord.getClassification()))
        .createdAt(universityCatalogRecord.getCreatedAt())
        .build();
  }
}
