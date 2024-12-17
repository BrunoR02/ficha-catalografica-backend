package com.ficha.catalografica.projeto.cataloging.infrastructure.record.database.embeddable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
@Embeddable
public class RecordClassificationEmbeddable {

  @Column(table = "cr_record_classification")
  private String cdd;

  @Column(table = "cr_record_classification")
  private String cdu;

  @Column(table = "cr_record_classification")
  private String cutter;

}
