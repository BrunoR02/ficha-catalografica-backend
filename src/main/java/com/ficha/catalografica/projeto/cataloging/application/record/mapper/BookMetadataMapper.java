package com.ficha.catalografica.projeto.cataloging.application.record.mapper;

import com.ficha.catalografica.projeto.cataloging.application.record.dto.BookDimensionDto;
import com.ficha.catalografica.projeto.cataloging.application.record.dto.BookEditionDto;
import com.ficha.catalografica.projeto.cataloging.application.record.dto.BookMetadataDto;
import com.ficha.catalografica.projeto.cataloging.application.record.dto.BookSeriesDto;
import com.ficha.catalografica.projeto.cataloging.domain.record.valueobject.BookDimension;
import com.ficha.catalografica.projeto.cataloging.domain.record.valueobject.BookEdition;
import com.ficha.catalografica.projeto.cataloging.domain.record.valueobject.BookMetadata;
import com.ficha.catalografica.projeto.cataloging.domain.record.valueobject.BookSeries;
import com.ficha.catalografica.projeto.cataloging.domain.record.valueobject.ISBN;

public class BookMetadataMapper {

  public static BookMetadata toDomain(BookMetadataDto dto) {
    BookEdition bookEdition = new BookEdition(dto.getEdition().getNumber(), dto.getEdition().getObservation());
    BookDimension bookDimension = new BookDimension(dto.getDimension().getWidth(), dto.getDimension().getHeight());
    BookSeries bookSeries = new BookSeries(dto.getSeries().getName(), dto.getSeries().getNumber());
    ISBN isbn = new ISBN(dto.getIsbn());

    return new BookMetadata(bookEdition, bookDimension, bookSeries, isbn);
  }

  public static BookMetadataDto toDto(BookMetadata bookMetadata) {
    BookEditionDto bookEdition = new BookEditionDto(bookMetadata.getEdition().getNumber(),
        bookMetadata.getEdition().getObservation());
    BookDimensionDto bookDimension = new BookDimensionDto(bookMetadata.getDimension().getWidth(),
        bookMetadata.getDimension().getHeight());
    BookSeriesDto bookSeries = new BookSeriesDto(bookMetadata.getSeries().getName(),
        bookMetadata.getSeries().getNumber());
    String isbn = bookMetadata.getIsbn().getValue();

    return new BookMetadataDto(bookEdition, bookDimension, bookSeries, isbn);
  }

}
