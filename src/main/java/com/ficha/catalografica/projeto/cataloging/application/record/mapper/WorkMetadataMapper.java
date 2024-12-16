package com.ficha.catalografica.projeto.cataloging.application.record.mapper;

import com.ficha.catalografica.projeto.cataloging.application.record.dto.WorkMetadataDto;
import com.ficha.catalografica.projeto.cataloging.domain.record.valueobject.WorkMetadata;

public class WorkMetadataMapper {

  public static WorkMetadata toDomain(WorkMetadataDto dto) {
    return new WorkMetadata(dto.getTitle(),
        dto.getFormat(),
        dto.getSubtitle(),
        dto.getPages(),
        dto.hasIllustration(),
        dto.hasColor());
  }

  public static WorkMetadataDto toDto(WorkMetadata workMetadata) {
    return new WorkMetadataDto(workMetadata.getTitle(),
        workMetadata.getFormat(),
        workMetadata.getSubtitle(),
        workMetadata.getPages(),
        workMetadata.hasIllustration(),
        workMetadata.hasColor());
  }

}
