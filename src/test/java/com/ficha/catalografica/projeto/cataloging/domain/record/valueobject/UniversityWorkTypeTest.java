package com.ficha.catalografica.projeto.cataloging.domain.record.valueobject;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("UniversityWorkType Unit Tests")
public class UniversityWorkTypeTest {
  @Test
  @DisplayName("parse should return UniversityWorkType object when value is parsed")
  void parse_shouldReturnUniversityWorkTypeObject_WhenValueIsParsed() {
    // Arrange
    List<String> values = List.of("graduation", "specialization", "master", "doctorate");

    // Act & Assert
    values.forEach(value -> {
      UniversityWorkType universityWorkType = UniversityWorkType.parse(value);
      Assertions.assertThat(universityWorkType).isNotNull();
      Assertions.assertThat(universityWorkType).isInstanceOf(UniversityWorkType.class);
    });
  }

  @Test
  @DisplayName("parse should throw IllegalArgumentException when value is not parsed")
  void parse_shouldThrowIllegalArgumentException_WhenValueIsNotParsed() {
    // Arrange
    List<String> values = List.of("test", "value");

    // Act & Assert
    values.forEach(value -> {
      Assertions.assertThatThrownBy(() -> UniversityWorkType.parse(value))
          .isInstanceOf(IllegalArgumentException.class)
          .hasMessage("Invalid value for UniversityWorkType. Only permitted: 'graduation', 'specialization', 'master', 'doctorate'");
    });
  }
}
