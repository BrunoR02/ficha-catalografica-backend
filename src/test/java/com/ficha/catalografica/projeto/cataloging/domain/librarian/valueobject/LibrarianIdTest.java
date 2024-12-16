package com.ficha.catalografica.projeto.cataloging.domain.librarian.valueobject;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LibrarianIdTest {

  @Test
  @DisplayName("constructor should throw IllegalArgumentException when value is invalid")
  public void constructor_shouldThrowIllegalArgumentException_whenValueIsInvalid() {
    // Arrange
    String invalidValue = " ";

    // Act & Assert
    Assertions.assertThatThrownBy(() -> new LibrarianId(invalidValue))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("librarianId value cannot be null or empty");
  }

  @Test
  @DisplayName("constructor should define value property when value is valid")
  public void constructor_shouldDefineValueProperty_whenValueIsValid() {
    // Arrange
    List<String> validValues = List.of("123456as",
        "asdujadshuiasd",
        "Tas888dua");

    // Act
    List<LibrarianId> ids = validValues.stream()
        .map(value -> new LibrarianId(value))
        .toList();

    // Assert
    ids.forEach(id -> {
      Assertions.assertThat(id).isNotNull().isInstanceOf(LibrarianId.class);
      Assertions.assertThat(id.getValue()).isNotNull();
    });
  }
}
