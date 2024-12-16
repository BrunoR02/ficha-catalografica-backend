package com.ficha.catalografica.projeto.cataloging.application.record.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BookMetadataDto {

  private BookEditionDto edition;

  private BookDimensionDto dimension;

  private BookSeriesDto series;

  private String isbn;
  
}
