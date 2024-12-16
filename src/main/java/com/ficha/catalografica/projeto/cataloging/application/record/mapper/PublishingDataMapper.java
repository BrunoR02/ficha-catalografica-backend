package com.ficha.catalografica.projeto.cataloging.application.record.mapper;

import com.ficha.catalografica.projeto.cataloging.application.record.dto.PublishingDataDto;
import com.ficha.catalografica.projeto.cataloging.domain.record.valueobject.PublishingData;

public class PublishingDataMapper {

  public static PublishingData toDomain(PublishingDataDto dto) {
    return new PublishingData(dto.getDate(), dto.getLocation());
  }

  public static PublishingDataDto toDto(PublishingData publishingData) {
    return new PublishingDataDto(publishingData.getDate(), publishingData.getLocation());
  }

}
