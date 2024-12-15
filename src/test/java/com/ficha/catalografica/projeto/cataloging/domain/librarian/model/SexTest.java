package com.ficha.catalografica.projeto.cataloging.domain.librarian.model;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Sex Unit Tests")
public class SexTest {

  @Test
  @DisplayName("parse should return sex object when value is parsed")
  void parse_shouldReturnSexObject_WhenValueIsParsed() {
    // Arrange
    List<String> values = List.of("male", "female");

    // Act & Assert
    values.forEach(value -> {
      Sex sex = Sex.parse(value);
      Assertions.assertThat(sex).isNotNull();
      Assertions.assertThat(sex).isInstanceOf(Sex.class);
    });
  }

  @Test
  @DisplayName("parse should throw IllegalArgumentException when value is not parsed")
  void parse_shouldThrowIllegalArgumentException_WhenValueIsNotParsed() {
    // Arrange
    List<String> values = List.of("test", "value");

    // Act & Assert
    values.forEach(value -> {
      Assertions.assertThatThrownBy(() -> Sex.parse(value))
          .isInstanceOf(IllegalArgumentException.class)
          .hasMessage("Invalid value for sex. Only permitted: 'male', 'female'");
    });
  }
}
