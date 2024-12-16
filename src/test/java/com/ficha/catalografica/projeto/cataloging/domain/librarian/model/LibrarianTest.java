package com.ficha.catalografica.projeto.cataloging.domain.librarian.model;

import java.time.LocalDate;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.ficha.catalografica.projeto.cataloging.domain.librarian.valueobject.Email;
import com.ficha.catalografica.projeto.cataloging.domain.librarian.valueobject.LibrarianInfo;
import com.ficha.catalografica.projeto.cataloging.domain.librarian.valueobject.Password;
import com.ficha.catalografica.projeto.cataloging.domain.librarian.valueobject.Sex;

@DisplayName("Librarian Unit Tests")
public class LibrarianTest {

  @Test
  @DisplayName("constructor should throw IllegalArgumentException when arguments are invalid")
  public void constructor_shouldThrowIllegalArgumentException_whenArgumentsAreInvalid() {
    // Arrange
    LibrarianInfo invalidLibrarianInfo = null;
    LibrarianInfo validLibrarianInfo = new LibrarianInfo("Bruno Lucas", Sex.MALE, LocalDate.of(2002, 2, 7));
    String validCrb = "332/45";
    String invalidCrb = " ";
    Email validEmail = new Email("brunolucas@gmail.com");
    Password validPassword = Password.fromRaw("Teste123456");

    // Act & Assert (invalid librarinInfo case)
    Assertions.assertThatThrownBy(() -> new Librarian(invalidLibrarianInfo, validEmail, validPassword, validCrb))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("librarianInfo cannot be null");

    // Act & Assert (invalid crb case)
    Assertions.assertThatThrownBy(() -> new Librarian(validLibrarianInfo, validEmail, validPassword, invalidCrb))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("crb cannot be null or empty");
  }

  @Test
  @DisplayName("constructor should return Librarian object when arguments are valid")
  public void constructor_shouldReturnLibrarianObject_whenArgumentsAreValid() {
    // Arrange
    LibrarianInfo validLibrarianInfo = new LibrarianInfo("Bruno Lucas", Sex.MALE, LocalDate.of(2002, 2, 7));
    String validCrb = "332/45";
    Email validEmail = new Email("brunolucas@gmail.com");
    Password validPassword = Password.fromRaw("Teste123456");

    // Act
    Librarian librarian = new Librarian(validLibrarianInfo, validEmail, validPassword, validCrb);

    // Assert
    Assertions.assertThat(librarian).isNotNull().isInstanceOf(Librarian.class);
  }
}
