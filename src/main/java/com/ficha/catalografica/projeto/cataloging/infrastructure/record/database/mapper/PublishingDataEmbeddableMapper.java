package com.ficha.catalografica.projeto.cataloging.infrastructure.record.database.mapper;

import com.ficha.catalografica.projeto.cataloging.domain.record.valueobject.PublishingData;
import com.ficha.catalografica.projeto.cataloging.infrastructure.record.database.embeddable.PublishingDataEmbeddable;

public class PublishingDataEmbeddableMapper {

  public static PublishingData toDomain(PublishingDataEmbeddable embeddable) {
    return new PublishingData(embeddable.getDate(), embeddable.getLocation());
  }

  public static PublishingDataEmbeddable toEmbeddable(PublishingData publishingData) {
    return new PublishingDataEmbeddable(publishingData.getDate(), publishingData.getLocation());
  }
}
