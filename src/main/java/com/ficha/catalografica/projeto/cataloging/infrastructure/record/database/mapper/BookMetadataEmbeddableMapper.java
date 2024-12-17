package com.ficha.catalografica.projeto.cataloging.infrastructure.record.database.mapper;

import com.ficha.catalografica.projeto.cataloging.domain.record.valueobject.BookDimension;
import com.ficha.catalografica.projeto.cataloging.domain.record.valueobject.BookEdition;
import com.ficha.catalografica.projeto.cataloging.domain.record.valueobject.BookMetadata;
import com.ficha.catalografica.projeto.cataloging.domain.record.valueobject.BookSeries;
import com.ficha.catalografica.projeto.cataloging.domain.record.valueobject.ISBN;
import com.ficha.catalografica.projeto.cataloging.infrastructure.record.database.embeddable.BookMetadataEmbeddable;

public class BookMetadataEmbeddableMapper {

  public static BookMetadata toDomain(BookMetadataEmbeddable embeddable) {
    BookEdition bookEdition = new BookEdition(embeddable.getEditionNumber(), embeddable.getEditionObservation());
    BookDimension bookDimension = new BookDimension(embeddable.getDimensionWidth(), embeddable.getDimensionHeight());
    BookSeries bookSeries = new BookSeries(embeddable.getSeriesName(), embeddable.getSeriesNumber());
    ISBN isbn = new ISBN(embeddable.getIsbn());

    return new BookMetadata(bookEdition, bookDimension, bookSeries, isbn);
  }

  public static BookMetadataEmbeddable toEmbeddable(BookMetadata bookMetadata) {

    return BookMetadataEmbeddable.builder()
        .editionNumber(bookMetadata.getEdition().getNumber())
        .editionObservation(bookMetadata.getEdition().getObservation())
        .dimensionWidth(bookMetadata.getDimension().getWidth())
        .dimensionHeight(bookMetadata.getDimension().getHeight())
        .seriesName(bookMetadata.getSeries().getName())
        .seriesNumber(bookMetadata.getSeries().getNumber())
        .isbn(bookMetadata.getIsbn().getValue())
        .build();
  }
}
