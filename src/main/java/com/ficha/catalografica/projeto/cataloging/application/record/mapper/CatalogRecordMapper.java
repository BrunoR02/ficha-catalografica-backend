package com.ficha.catalografica.projeto.cataloging.application.record.mapper;

import com.ficha.catalografica.projeto.cataloging.application.record.command.CreateCatalogRecordCommand;
import com.ficha.catalografica.projeto.cataloging.application.record.dto.CatalogRecordDto;
import com.ficha.catalografica.projeto.cataloging.domain.librarian.valueobject.LibrarianId;
import com.ficha.catalografica.projeto.cataloging.domain.record.model.CatalogRecord;

public class CatalogRecordMapper {

  public static CatalogRecord toDomain(CreateCatalogRecordCommand command) {
    return CatalogRecord.builder()
        .creatorId(new LibrarianId(command.getCreatorId()))
        .responsabilities(command.getResponsabilities())
        .workMetadata(WorkMetadataMapper.toDomain(command.getWorkMetadata()))
        .translator(command.getTranslator())
        .publishingData(PublishingDataMapper.toDomain(command.getPublishingData()))
        .publisherName(command.getPublisherName())
        .bookMetadata(BookMetadataMapper.toDomain(command.getBookMetadata()))
        .notes(command.getNotes())
        .secondarySubjects(command.getSecondarySubjects())
        .classification(RecordClassificationMapper.toDomain(command.getClassification()))
        .build();
  }

  public static CatalogRecordDto toDto(CatalogRecord catalogRecord) {
    return CatalogRecordDto.builder()
        .id(catalogRecord.getId().getValue())
        .creatorId(catalogRecord.getCreatorId().getValue())
        .responsabilities(catalogRecord.getResponsabilities())
        .workMetadata(WorkMetadataMapper.toDto(catalogRecord.getWorkMetadata()))
        .translator(catalogRecord.getTranslator())
        .publishingData(PublishingDataMapper.toDto(catalogRecord.getPublishingData()))
        .publisherName(catalogRecord.getPublisherName())
        .bookMetadata(BookMetadataMapper.toDto(catalogRecord.getBookMetadata()))
        .notes(catalogRecord.getNotes())
        .secondarySubjects(catalogRecord.getSecondarySubjects())
        .classification(RecordClassificationMapper.toDto(catalogRecord.getClassification()))
        .createdAt(catalogRecord.getCreatedAt())
        .build();
  }

}
