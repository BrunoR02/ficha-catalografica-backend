package com.ficha.catalografica.projeto.cataloging.domain.record.valueobject;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("UniversityWorkMetadata Unit Tests")
public class UniversityWorkMetadataTest {

  @Test
  @DisplayName("constructor should throw IllegalArgumentException when arguments are invalid")
  public void constructor_shouldThrowIllegalArgumentException_whenArgumentsAreInvalid() {
    // Arrange
    UniversityWorkType invalidWorkType = null;
    String invalidUniversityName = " ";
    String invalidDegreeCourse = " ";
    String invalidDepartment = " ";
    UniversityWorkType validWorkType = UniversityWorkType.GRADUATION;
    String validUniversityName = "Universidade Federal de Sergipe";
    String validDegreeCourse = "Ciência da Computação";
    String validIssn = "123465";

    // Act & Assert (invalid workType case)
    Assertions
        .assertThatThrownBy(() -> new UniversityWorkMetadata(invalidWorkType, invalidUniversityName,
            invalidDegreeCourse, invalidDepartment, validIssn))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("workType cannot be null");

    // Act & Assert (invalid universityName case)
    Assertions
        .assertThatThrownBy(() -> new UniversityWorkMetadata(validWorkType, invalidUniversityName, invalidDegreeCourse,
            invalidDepartment, validIssn))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("universityName cannot be null or empty");

    // Act & Assert (invalid degreeCourse case)
    Assertions
        .assertThatThrownBy(() -> new UniversityWorkMetadata(validWorkType, validUniversityName, invalidDegreeCourse,
            invalidDepartment, validIssn))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("degreeCourse cannot be null or empty");

    // Act & Assert (invalid departament case)
    Assertions
        .assertThatThrownBy(() -> new UniversityWorkMetadata(validWorkType, validUniversityName, validDegreeCourse,
            invalidDepartment, validIssn))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("department cannot be null or empty");
  }

  @Test
  @DisplayName("constructor should return UniversityWorkMetadata object when arguments are valid")
  public void constructor_shouldReturnUniversityWorkMetadataObject_whenArgumentsAreValid() {
    // Arrange
    UniversityWorkType validWorkType = UniversityWorkType.GRADUATION;
    String validUniversityName = "Universidade Federal de Sergipe";
    String validDegreeCourse = "Ciência da Computação";
    String validDepartment = "Departamento de Computação";
    String validIssn = "123465";

    // Act
    UniversityWorkMetadata universityWorkMetadata = new UniversityWorkMetadata(validWorkType, validUniversityName,
        validDegreeCourse, validDepartment, validIssn);

    // Assert
    Assertions.assertThat(universityWorkMetadata)
        .isNotNull()
        .isInstanceOf(UniversityWorkMetadata.class);
  }
}
