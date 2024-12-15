package com.ficha.catalografica.projeto.librarian.domain.librarian.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.ficha.catalografica.projeto.librarian.domain.librarian.exception.AlreadyExistsException;
import com.ficha.catalografica.projeto.librarian.domain.librarian.model.Email;
import com.ficha.catalografica.projeto.librarian.domain.librarian.model.Librarian;
import com.ficha.catalografica.projeto.librarian.domain.librarian.model.LibrarianInfo;
import com.ficha.catalografica.projeto.librarian.domain.librarian.model.Password;
import com.ficha.catalografica.projeto.librarian.domain.librarian.model.Sex;
import com.ficha.catalografica.projeto.librarian.domain.librarian.ports.outbounds.LibrarianExistsPort;
import com.ficha.catalografica.projeto.librarian.domain.librarian.ports.outbounds.RegisterLibrarianPort;

@ExtendWith(SpringExtension.class)
@DisplayName("RegisterLibrarianService Unit Tests")
public class RegisterLibrarianServiceTest {

  @InjectMocks
  private RegisterLibrarianService registerLibrarianService;

  @Mock
  private LibrarianExistsPort librarianExistsPort;

  @Mock
  private RegisterLibrarianPort registerLibrarianPort;

  @Test
  @DisplayName("registerLibrarian should throw AlreadyExistsException when new librarian email is already in use")
  void registerLibrarian_shouldThrowAlreadyExistsException_whenNewLibrarianEmailIsAlreadyInUse() {
    // Arrange
    Email testEmail = new Email("test@test.com");
    Librarian testLibrarian = new Librarian(
        new LibrarianInfo("Teste", Sex.MALE, LocalDate.now()),
        testEmail,
        Password.fromRaw("Test123456"),
        "123/12");

    when(librarianExistsPort.librarianExistsByEmail(testEmail))
        .thenReturn(true);

    // Act & Assert
    Assertions.assertThatThrownBy(() -> registerLibrarianService.registerLibrarian(testLibrarian))
        .isInstanceOf(AlreadyExistsException.class)
        .hasMessage("Already exists a librarian registered with this email");

    // Verify that librarianExistsPort method 'librarianExistsByEmail' is called
    // correctly
    verify(librarianExistsPort, times(1)).librarianExistsByEmail(any(Email.class));

    // Verify that registerLibrarianPort method 'registerLibrarian' is not called
    verify(registerLibrarianPort, never()).registerLibrarian(any());
  }

  @Test
  @DisplayName("registerLibrarian should not throw any exception when successful")
  void registerLibrarian_shouldNotThrowAnyException_whenSuccessful() {
    // Arrange
    Email testEmail = new Email("test@test.com");
    Librarian testLibrarian = new Librarian(
        new LibrarianInfo("Teste", Sex.MALE, LocalDate.now()),
        testEmail,
        Password.fromRaw("Test123456"),
        "123/12");

    when(librarianExistsPort.librarianExistsByEmail(any(Email.class)))
        .thenReturn(false);

    // Act & Assert
    Assertions.assertThatNoException().isThrownBy(() -> registerLibrarianService.registerLibrarian(testLibrarian));

    // Verify that librarianExistsPort method 'librarianExistsByEmail' is called
    // correctly
    verify(librarianExistsPort, times(1)).librarianExistsByEmail(any(Email.class));

    // Verify that registerLibrarianPort method 'registerLibrarian' is called
    // correctly
    verify(registerLibrarianPort, times(1)).registerLibrarian(any(Librarian.class));
  }
}
