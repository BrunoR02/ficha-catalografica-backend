package com.ficha.catalografica.projeto.librarian.domain.librarian.model;

import java.time.LocalDate;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("LibrarianInfo Unit Tests")
public class LibrarianInfoTest {

  @Test
  @DisplayName("constructor should throw IllegalArgumentException when arguments are invalid")
  public void constructor_shouldThrowIllegalArgumentException_whenArgumentsAreInvalid() {
    // Arrange
    String validFullname = "Bruno Lucas";
    Sex validSex = Sex.MALE;
    String invalidFullname = " ";
    Sex invalidSex = null;
    LocalDate invalidBirthDate = null;

    // Act & Assert (invalid fullname case)
    Assertions.assertThatThrownBy(() -> new LibrarianInfo(invalidFullname, invalidSex, invalidBirthDate))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("fullName cannot be null or empty");

    // Act & Assert (invalid sex case)
    Assertions.assertThatThrownBy(() -> new LibrarianInfo(validFullname, invalidSex, invalidBirthDate))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("sex cannot be null");

    // Act & Assert (invalid birthDate case)
    Assertions.assertThatThrownBy(() -> new LibrarianInfo(validFullname, validSex, invalidBirthDate))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("birthDate cannot be null");
  }

  @Test
  @DisplayName("constructor should return LibrarianInfo object when arguments are valid")
  public void constructor_shouldReturnLibrarianInfoObject_whenArgumentsAreValid() {
    // Arrange
    String validFullname = "Bruno Lucas";
    Sex validSex = Sex.MALE;
    LocalDate validBirthDate = LocalDate.of(2002, 2, 7);

    // Act
    LibrarianInfo librarianInfo = new LibrarianInfo(validFullname, validSex, validBirthDate);

    // Assert
    Assertions.assertThat(librarianInfo).isNotNull().isInstanceOf(LibrarianInfo.class);
  }
}
