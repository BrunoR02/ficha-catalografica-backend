package com.ficha.catalografica.projeto.cataloging.application.record.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RecordClassificationDto {
  
  private String cdd;

  private String cdu;

  private String cutter;
}
