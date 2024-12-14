package com.ficha.catalografica.projeto.librarian.domain.librarian.model;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Email UnitTests")
public class EmailTest {

  @Test
  @DisplayName("constructor should throw IllegalArgumentException when email is invalid")
  public void constructor_shouldThrowIllegalArgumentException_whenEmailIsInvalid() {
    // Arrange
    List<String> invalidEmails = List.of("",
        "testgmail.com",
        "test@gmail",
        "test@",
        "@test.com",
        "@.com",
        "test");

    // Act & Assert
    invalidEmails.forEach(email -> {
      Assertions.assertThatThrownBy(() -> new Email(email))
          .isInstanceOf(IllegalArgumentException.class)
          .hasMessage("Email is invalid");
    });

  }

  @Test
  @DisplayName("constructor should define value property when email is valid")
  public void constructor_shouldDefineValueProperty_whenEmailIsValid() {
    // Arrange
    List<String> validEmails = List.of("test@test.com",
        "test@gmail.com",
        "test@ads.jp");

    // Act
    List<Email> emails = validEmails.stream()
        .map(email -> new Email(email))
        .toList();

    // Assert
    emails.forEach(email -> {
      Assertions.assertThat(email.getValue()).isNotNull();
    });
  }

}
