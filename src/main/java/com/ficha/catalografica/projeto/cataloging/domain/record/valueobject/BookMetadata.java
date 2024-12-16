package com.ficha.catalografica.projeto.cataloging.domain.record.valueobject;

import io.micrometer.common.util.StringUtils;
import lombok.Getter;

@Getter
public class BookMetadata {

  private final BookEdition edition;

  private final BookDimensions dimensions;

  private final BookSeries series;

  private final String isbn;

  public BookMetadata(String isbn, int pages, BookEdition edition, BookDimensions dimensions, BookSeries series,
      boolean hasIllustration, boolean hasColor) {
    if (StringUtils.isBlank(isbn))
      throw new IllegalArgumentException("isbn cannot be null or empty");

    this.edition = edition;
    this.dimensions = dimensions;
    this.series = series;
    this.isbn = isbn;
  }

}
