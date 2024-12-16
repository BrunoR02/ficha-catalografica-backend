package com.ficha.catalografica.projeto.cataloging.domain.record.valueobject;

import lombok.Getter;

@Getter
public class BookMetadata {

  private final BookEdition edition;

  private final BookDimensions dimensions;

  private final BookSeries series;

  private final ISBN isbn;

  public BookMetadata(BookEdition edition, BookDimensions dimensions, BookSeries series,
      ISBN isbn) {
    if (isbn == null)
      throw new IllegalArgumentException("isbn cannot be null");

    this.edition = edition;
    this.dimensions = dimensions;
    this.series = series;
    this.isbn = isbn;
  }

}
