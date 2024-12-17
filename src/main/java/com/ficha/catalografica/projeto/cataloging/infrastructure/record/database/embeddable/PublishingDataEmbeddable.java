package com.ficha.catalografica.projeto.cataloging.infrastructure.record.database.embeddable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
@AllArgsConstructor
@Embeddable
public class PublishingDataEmbeddable {

  @Column(table = "cr_publishing_data")
  private LocalDate date;

  @Column(table = "cr_publishing_data")
  private String location;

}
