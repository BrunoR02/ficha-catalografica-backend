package com.ficha.catalografica.projeto.cataloging.domain.record.valueobject;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("WorkMetadata Unit Tests")
public class WorkMetadataTest {

  @Test
  @DisplayName("constructor should throw IllegalArgumentException when arguments are invalid")
  public void constructor_shouldThrowIllegalArgumentException_whenArgumentsAreInvalid() {
    // Arrange
    String invalidTitle = " ";
    String invalidFormat = " ";
    String invalidSubtitle = " ";
    int invalidPages = 0;
    String validTitle = "Mais esperto que o Diabo";
    String validFormat = "e-book";
    String validSubtitle = "Como usar o poder da mente";

    // Act & Assert (invalid title case)
    Assertions
        .assertThatThrownBy(
            () -> new WorkMetadata(invalidTitle, invalidFormat, invalidSubtitle, invalidPages, true, true))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("title cannot be null or empty");

    // Act & Assert (invalid format case)
    Assertions
        .assertThatThrownBy(
            () -> new WorkMetadata(validTitle, invalidFormat, invalidSubtitle, invalidPages, true, true))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("format cannot be null or empty");

    // Act & Assert (invalid subtitle case)
    Assertions
        .assertThatThrownBy(
            () -> new WorkMetadata(validTitle, validFormat, invalidSubtitle, invalidPages, true, true))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("subtitle cannot be null or empty");

    // Act & Assert (invalid pages case)
    Assertions
        .assertThatThrownBy(
            () -> new WorkMetadata(validTitle, validFormat, validSubtitle, invalidPages, true, true))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("pages have to be greater than zero");
  }

  @Test
  @DisplayName("constructor should return WorkMetadata object when arguments are valid")
  public void constructor_shouldReturnWorkMetadataObject_whenArgumentsAreValid() {
    // Arrange
    String validTitle = "Mais esperto que o Diabo";
    String validFormat = "e-book";
    String validSubtitle = "Como usar o poder da mente";
    int validPages = 200;

    // Act
    WorkMetadata workMetadata = new WorkMetadata(validTitle, validFormat, validSubtitle, validPages, false, false);

    // Assert
    Assertions.assertThat(workMetadata)
        .isNotNull()
        .isInstanceOf(WorkMetadata.class);
  }
}
