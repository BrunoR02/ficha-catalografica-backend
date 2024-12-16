package com.ficha.catalografica.projeto.cataloging.application.record.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PublishingDataDto {
  
  private LocalDate date;

  private String location;
}
