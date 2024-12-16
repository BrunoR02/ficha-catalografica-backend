package com.ficha.catalografica.projeto.cataloging.domain.record.valueobject;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("BookMetadata Unit Test")
public class BookMetadataTest {

  @Test
  @DisplayName("constructor should throw IllegalArgumentException when arguments are invalid")
  public void constructor_shouldThrowIllegalArgumentException_whenArgumentsAreInvalid() {
    // Arrange
    ISBN invalidISBN = null;
    BookEdition validBookEdition = new BookEdition(1, "test");
    BookDimensions validBookDimensions = new BookDimensions(10, 20);
    BookSeries validBookSeries = new BookSeries("Test", 2);

    // Act & Assert (invalid isbn case)
    Assertions
        .assertThatThrownBy(() -> new BookMetadata(validBookEdition, validBookDimensions, validBookSeries, invalidISBN))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("isbn cannot be null");
  }

  @Test
  @DisplayName("constructor should return bookMetadata object when arguments are valid")
  public void constructor_shouldReturnBookMetadataObject_whenArgumentsAreValid() {
    // Arrange
    ISBN validISBN = new ISBN("1234567891");
    BookEdition validBookEdition = new BookEdition(1, "test");
    BookDimensions validBookDimensions = new BookDimensions(10, 20);
    BookSeries validBookSeries = new BookSeries("Test", 2);

    // Act
    BookMetadata bookMetadata = new BookMetadata(validBookEdition, validBookDimensions, validBookSeries, validISBN);

    // Assert
    Assertions.assertThat(bookMetadata)
        .isNotNull()
        .isInstanceOf(BookMetadata.class);
  }
}
