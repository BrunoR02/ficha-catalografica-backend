package com.ficha.catalografica.projeto.cataloging.application.record.mapper;

import com.ficha.catalografica.projeto.cataloging.application.record.dto.UniversityWorkMetadataDto;
import com.ficha.catalografica.projeto.cataloging.domain.record.valueobject.UniversityWorkMetadata;
import com.ficha.catalografica.projeto.cataloging.domain.record.valueobject.UniversityWorkType;

public class UniversityWorkMetadataMapper {

  public static UniversityWorkMetadata toDomain(UniversityWorkMetadataDto dto) {
    return new UniversityWorkMetadata(UniversityWorkType.parse(dto.getWorkType()),
        dto.getUniversityName(),
        dto.getDegreeCourse(),
        dto.getDepartment(),
        dto.getIssn());
  }

  public static UniversityWorkMetadataDto toDto(UniversityWorkMetadata universityWorkMetadata) {
    return new UniversityWorkMetadataDto(
        universityWorkMetadata.getWorkType().getValue(),
        universityWorkMetadata.getUniversityName(),
        universityWorkMetadata.getDegreeCourse(),
        universityWorkMetadata.getDepartment(),
        universityWorkMetadata.getIssn());
  }

}
