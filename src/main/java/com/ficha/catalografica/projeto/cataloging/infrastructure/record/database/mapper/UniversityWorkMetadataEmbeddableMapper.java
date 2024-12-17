package com.ficha.catalografica.projeto.cataloging.infrastructure.record.database.mapper;

import com.ficha.catalografica.projeto.cataloging.domain.record.valueobject.UniversityWorkMetadata;
import com.ficha.catalografica.projeto.cataloging.infrastructure.record.database.embeddable.UniversityWorkMetadataEmbeddable;

public class UniversityWorkMetadataEmbeddableMapper {

  public static UniversityWorkMetadata toDomain(UniversityWorkMetadataEmbeddable embeddable) {
    return new UniversityWorkMetadata(
        embeddable.getWorkType(),
        embeddable.getUniversityName(),
        embeddable.getDegreeCourse(),
        embeddable.getDepartment(),
        embeddable.getIssn());
  }

  public static UniversityWorkMetadataEmbeddable toEmbeddable(UniversityWorkMetadata universityWorkMetadata) {
    return new UniversityWorkMetadataEmbeddable(
        universityWorkMetadata.getWorkType(),
        universityWorkMetadata.getUniversityName(),
        universityWorkMetadata.getDegreeCourse(),
        universityWorkMetadata.getDepartment(),
        universityWorkMetadata.getIssn());
  }

}
