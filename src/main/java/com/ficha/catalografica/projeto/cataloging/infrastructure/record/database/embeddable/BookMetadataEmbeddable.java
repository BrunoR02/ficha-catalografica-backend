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
public class BookMetadataEmbeddable {

  @Column(name = "edition_number", table = "cr_book_metadata")
  private int editionNumber;
  
  @Column(name = "edition_observation", table = "cr_book_metadata")
  private String editionObservation;

  @Column(name = "dimension_width", table = "cr_book_metadata")
  private int dimensionWidth;

  @Column(name = "dimension_height", table = "cr_book_metadata")
  private int dimensionHeight;

  @Column(name = "series_name", table = "cr_book_metadata")
  private String seriesName;

  @Column(name = "series_number", table = "cr_book_metadata")
  private int seriesNumber;

  @Column(name = "isbn", table = "cr_book_metadata")
  private String isbn;
}
