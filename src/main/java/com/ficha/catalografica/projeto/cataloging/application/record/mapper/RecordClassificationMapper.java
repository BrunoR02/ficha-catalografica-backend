package com.ficha.catalografica.projeto.cataloging.application.record.mapper;

import com.ficha.catalografica.projeto.cataloging.application.record.dto.RecordClassificationDto;
import com.ficha.catalografica.projeto.cataloging.domain.record.valueobject.RecordClassification;

public class RecordClassificationMapper {

  public static RecordClassification toDomain(RecordClassificationDto dto) {
    return new RecordClassification(dto.getCdd(), dto.getCdu(), dto.getCutter());
  }

  public static RecordClassificationDto toDto(RecordClassification classification) {
    return new RecordClassificationDto(classification.getCdd(), classification.getCdu(), classification.getCutter());
  }
}
