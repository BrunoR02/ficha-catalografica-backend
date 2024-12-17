package com.ficha.catalografica.projeto.cataloging.infrastructure.record.database.mapper;

import com.ficha.catalografica.projeto.cataloging.domain.record.valueobject.RecordClassification;
import com.ficha.catalografica.projeto.cataloging.infrastructure.record.database.embeddable.RecordClassificationEmbeddable;

public class RecordClassificationEmbeddableMapper {

  public static RecordClassification toDomain(RecordClassificationEmbeddable embeddable) {
    return new RecordClassification(embeddable.getCdd(), embeddable.getCdu(), embeddable.getCutter());
  }

  public static RecordClassificationEmbeddable toEmbeddable(RecordClassification classification) {
    return new RecordClassificationEmbeddable(classification.getCdd(), classification.getCdu(),
        classification.getCutter());
  }

}
