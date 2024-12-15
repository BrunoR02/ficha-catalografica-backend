package com.ficha.catalografica.projeto.cataloging.domain.librarian.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.ficha.catalografica.projeto.cataloging.domain.librarian.exception.InvalidCredentialsException;
import com.ficha.catalografica.projeto.cataloging.domain.librarian.model.Email;
import com.ficha.catalografica.projeto.cataloging.domain.librarian.model.Librarian;
import com.ficha.catalografica.projeto.cataloging.domain.librarian.model.LibrarianInfo;
import com.ficha.catalografica.projeto.cataloging.domain.librarian.model.Password;
import com.ficha.catalografica.projeto.cataloging.domain.librarian.model.Sex;
import com.ficha.catalografica.projeto.cataloging.domain.librarian.ports.outbounds.FindLibrarianByCrbPort;
import com.ficha.catalografica.projeto.cataloging.domain.librarian.ports.outbounds.FindLibrarianByEmailPort;

@ExtendWith(SpringExtension.class)
@DisplayName("LoginLibrarianService Unit Tests")
public class LoginLibrarianServiceTest {

  @InjectMocks
  private LoginLibrarianService loginLibrarianService;

  @Mock
  private FindLibrarianByEmailPort findLibrarianByEmailPort;

  @Mock
  private FindLibrarianByCrbPort findLibrarianByCrbPort;

  @Test
  @DisplayName("login should throw InvalidCredentialsException when credentials are invalid")
  void login_shouldThrowInvalidCredentialsException_whenCredentialsAreInvalid() {
    // Arrange
    Email wrongEmail = new Email("wrong@teste.com");
    String wrongPasswordValue = "Teste123465";
    String wrongCrbValue = "123";
    Email rightEmail = new Email("right@test.com");
    Password rightPassword = Password.fromRaw("RightTest123");
    String rightCrb = "123/56";

    Librarian repositoryLibrarian = new Librarian(
        new LibrarianInfo("Teste", Sex.MALE, LocalDate.now()),
        rightEmail,
        rightPassword,
        rightCrb);

    when(findLibrarianByEmailPort.findByEmail(rightEmail))
        .thenReturn(Optional.of(repositoryLibrarian));
    when(findLibrarianByEmailPort.findByEmail(wrongEmail))
        .thenReturn(Optional.ofNullable(null));
    when(findLibrarianByCrbPort.findByCrb(wrongCrbValue))
        .thenReturn(Optional.ofNullable(null));

    // Act & Assert (invalid email case)
    Assertions.assertThatThrownBy(() -> loginLibrarianService.login(wrongEmail.getValue(), wrongPasswordValue, null))
        .isInstanceOf(InvalidCredentialsException.class)
        .hasMessage("Invalid email or password");

    // Act & Assert (invalid crb case)
    Assertions.assertThatThrownBy(() -> loginLibrarianService.login(null, wrongPasswordValue, wrongCrbValue))
        .isInstanceOf(InvalidCredentialsException.class)
        .hasMessage("Invalid crb or password");

    // Act & Assert (invalid password case)
    Assertions.assertThatThrownBy(() -> loginLibrarianService.login(rightEmail.getValue(), wrongPasswordValue, null))
        .isInstanceOf(InvalidCredentialsException.class)
        .hasMessage("Invalid email or password");

    // Act & Assert (invalid email and crb case)
    Assertions.assertThatThrownBy(() -> loginLibrarianService.login(null, wrongPasswordValue, null))
        .isInstanceOf(InvalidCredentialsException.class)
        .hasMessage("email or crb is required");


    // Verify that findLibrarianByEmailPort method 'findByEmail' is called correctly 
    verify(findLibrarianByEmailPort, times(2)).findByEmail(any(Email.class));

    // Verify that findLibrarianByCrbPort method 'findByCrb' is called correctly 
    verify(findLibrarianByCrbPort, times(1)).findByCrb(anyString());
  }

  @Test
  @DisplayName("login should return librarian when credentials are valid")
  void login_shouldReturnLibrarian_WhenCredentialsAreValid() {
    // Arrange
    String testEmailValue = "test@teste.com";
    Email testEmail = new Email(testEmailValue);
    String testPasswordValue = "RightTest123";
    Password testPassword = Password.fromRaw(testPasswordValue);

    Librarian repositoryLibrarian = new Librarian(
        new LibrarianInfo("Teste", Sex.MALE, LocalDate.now()),
        testEmail,
        testPassword,
        "123/54");

    when(findLibrarianByEmailPort.findByEmail(any(Email.class))).thenReturn(Optional.of(repositoryLibrarian));

    // Act
    Librarian librarian = loginLibrarianService.login(testEmailValue, testPasswordValue, null);

    // Assert
    Assertions.assertThat(librarian)
        .isNotNull()
        .isInstanceOf(Librarian.class);

    Assertions.assertThat(librarian.getEmail().getValue()).isEqualTo(testEmailValue);
    Assertions.assertThat(librarian.getPassword().matches(testPasswordValue)).isTrue();

    // Verify that findLibrarianByEmailPort method 'findByEmail' is called correctly 
    verify(findLibrarianByEmailPort, times(1)).findByEmail(any(Email.class));
  }
}
