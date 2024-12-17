package com.ficha.catalografica.projeto.cataloging.infrastructure.record.database.mapper;

import com.ficha.catalografica.projeto.cataloging.domain.record.valueobject.WorkMetadata;
import com.ficha.catalografica.projeto.cataloging.infrastructure.record.database.embeddable.WorkMetadataEmbeddable;

public class WorkMetadataEmbeddableMapper {

  public static WorkMetadata toDomain(WorkMetadataEmbeddable embeddable) {
    return new WorkMetadata(embeddable.getTitle(),
        embeddable.getFormat(),
        embeddable.getSubtitle(),
        embeddable.getPages(),
        embeddable.hasIllustration(),
        embeddable.hasColor());
  }

  public static WorkMetadataEmbeddable toEmbeddable(WorkMetadata workMetadata) {
    return new WorkMetadataEmbeddable(workMetadata.getTitle(),
        workMetadata.getFormat(),
        workMetadata.getSubtitle(),
        workMetadata.getPages(),
        workMetadata.hasIllustration(),
        workMetadata.hasColor());
  }
}
