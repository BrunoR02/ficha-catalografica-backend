package com.ficha.catalografica.projeto.cataloging.domain.librarian.valueobject;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PasswordTest {

  @Test
  @DisplayName("fromRaw should return password object when password is valid")
  void fromRaw_shouldReturnPasswordObject_whenPasswordIsValid() {
    // Arrange
    List<String> validPasswords = List.of("Teste123456", "passWord789");

    // Act & Assert
    validPasswords.forEach(validPassword -> {
      Password password = Password.fromRaw(validPassword);
      Assertions.assertThat(password).isNotNull();
      Assertions.assertThat(password).isInstanceOf(Password.class);
      Assertions.assertThat(password.getHashedValue()).isNotNull();
    });
  }

  @Test
  @DisplayName("isPasswordValid should return false when password is invalid")
  void isPasswordValid_shouldReturnFalse_whenPasswordIsInvalid() {
    // Arrange
    List<String> invalidPasswords = List.of("123456", "@@@a", "", "teste123456");

    // Act & Assert
    invalidPasswords.forEach(password -> {
      Assertions.assertThat(Password.isPasswordValid(password)).isFalse();
    });
  }

  @Test
  @DisplayName("isPasswordValid should return true when password is valid")
  void isPasswordValid_shouldReturnTrue_whenPasswordIsValid() {
    // Arrange
    List<String> validPasswords = List.of("Teste123456", "passWord789", "#1s2a3456@A");

    // Act & Assert
    validPasswords.forEach(validPassword -> {
      Assertions.assertThat(Password.isPasswordValid(validPassword)).isTrue();
    });
  }

  @Test
  @DisplayName("matches should return true when password is equal")
  void matches_shouldReturnTrue_whenPasswordIsEqual() {
    // Arrange
    String passwordValue = "Teste123456@";
    Password password = Password.fromRaw(passwordValue);

    // Act
    boolean result = password.matches(passwordValue);

    // Assert
    Assertions.assertThat(result).isTrue();
  }

  @Test
  @DisplayName("matches should return false when password is not equal")
  void matches_shouldReturnFalse_whenPasswordIsNotEqual() {
    // Arrange
    String passwordValue = "Teste123456@";
    String differentPasswordValue = "123as65@A";
    Password password = Password.fromRaw(passwordValue);

    // Act
    boolean result = password.matches(differentPasswordValue);

    // Assert
    Assertions.assertThat(result).isFalse();
  }
}
