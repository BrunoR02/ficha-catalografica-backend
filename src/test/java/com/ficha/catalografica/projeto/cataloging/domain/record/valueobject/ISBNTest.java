package com.ficha.catalografica.projeto.cataloging.domain.record.valueobject;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("ISBN Unit Tests")
public class ISBNTest {

  @Test
  @DisplayName("constructor should throw IllegalArgumentException when isbn value is invalid")
  public void constructor_shouldThrowIllegalArgumentException_whenIsbnValueIsInvalid() {
    // Arrange
    String emptyIsbnValue = " ";
    String notNumericIsbnValue = "123asd56";
    String wrongLengthIsbnValue = "123";

    // Act & Assert (empty isbn case)
    Assertions
        .assertThatThrownBy(() -> new ISBN(emptyIsbnValue))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("isbn value cannot be null or empty");

    // Act & Assert (not numeric isbn case)
    Assertions
        .assertThatThrownBy(() -> new ISBN(notNumericIsbnValue))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("isbn have invalid characters. Only number is permitted");

    // Act & Assert (wrong length isbn case)
    Assertions
        .assertThatThrownBy(() -> new ISBN(wrongLengthIsbnValue))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("isbn length have to be 10 or 13");
  }

  @Test
  @DisplayName("constructor should return isbn object when isbn value is valid")
  public void constructor_shouldReturnIsbnObject_whenIsbnValueIsValid() {
    // Arrange
    List<String> validIsbnValues = List.of("1234567897", "5789874561231");

    // Act & Assert
    validIsbnValues.stream().forEach(isbnValue -> {
      ISBN isbn = new ISBN(isbnValue);

      Assertions.assertThat(isbn)
          .isNotNull()
          .isInstanceOf(ISBN.class);
    });
  }
}
