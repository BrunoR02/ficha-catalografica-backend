package com.ficha.catalografica.projeto.cataloging.application.librarian.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import com.ficha.catalografica.projeto.cataloging.application.librarian.command.LoginLibrarianCommand;
import com.ficha.catalografica.projeto.cataloging.application.librarian.command.RegisterLibrarianCommand;
import com.ficha.catalografica.projeto.cataloging.application.librarian.mapper.LibrarianMapper;
import com.ficha.catalografica.projeto.cataloging.application.librarian.response.LoginLibrarianResponse;
import com.ficha.catalografica.projeto.cataloging.domain.librarian.model.Librarian;
import com.ficha.catalografica.projeto.cataloging.infrastructure.librarian.database.mapper.LibrarianEntityMapper;
import com.ficha.catalografica.projeto.cataloging.infrastructure.librarian.database.repository.LibrarianRepository;
import com.ficha.catalografica.projeto.common.exception.ExceptionDetails;
import com.ficha.catalografica.projeto.common.service.JwtTokenService;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
@Testcontainers
@DisplayName("LibrarianController Integration Test")
public class LibrarianControllerIT {

  @Container
  private static final PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:16-alpine");

  @DynamicPropertySource
  static void configureProperties(DynamicPropertyRegistry registry) {
    registry.add("spring.datasource.url", postgres::getJdbcUrl);
    registry.add("spring.datasource.username", postgres::getUsername);
    registry.add("spring.datasource.password", postgres::getPassword);
    registry.add("spring.datasource.driver-class-name", () -> "org.postgresql.Driver");
  }

  @Autowired
  private TestRestTemplate restTemplate;

  @Autowired
  private LibrarianRepository librarianRepository;

  @BeforeEach
  void beforeEach() {
    librarianRepository.deleteAll();
  }

  private HttpHeaders getHttpHeaders() {
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    return headers;
  }

  private <T> RequestEntity<T> getRequestEntity(HttpMethod method, URI uri, T body) {
    return new RequestEntity<T>(body, getHttpHeaders(),
        HttpMethod.POST, uri);
  }

  private Librarian getDomainLibrarian(String email, String crb, String password) {
    return LibrarianMapper.toDomain(
        new RegisterLibrarianCommand(
            "Bruno Lucas",
            email,
            password,
            "male",
            LocalDate.of(2002, 2, 2),
            crb));
  }

  @Test
  @SuppressWarnings("null")
  @DisplayName("POST /register should return BAD_REQUEST status when librarian email is already in use")
  void postRegister_shouldReturnBadRequestStatus_WhenLibrarianEmailIsAlreadyInUse() throws URISyntaxException {
    // Arrange
    String testEmail = "test@test.com";
    String testCrb = "123/55";
    String testPassword = "Test123456";
    RegisterLibrarianCommand command = new RegisterLibrarianCommand(
        "Bruno Lucas",
        "test@test.com",
        "Test123456",
        "male",
        LocalDate.of(2002, 2, 2),
        "123/55");

    RequestEntity<RegisterLibrarianCommand> requestEntity = getRequestEntity(
        HttpMethod.POST,
        new URI("/api/librarian/register"),
        command);

    // Save an librarian with the same email before trying to register
    Librarian domainLibrarian = getDomainLibrarian(testEmail, testCrb, testPassword);
    librarianRepository.saveAndFlush(LibrarianEntityMapper.toEntity(domainLibrarian));

    // Act
    ResponseEntity<ExceptionDetails> response = restTemplate.exchange(requestEntity, ExceptionDetails.class);

    // Assert
    Assertions.assertThat(response).isNotNull();
    Assertions.assertThat(response.getBody()).isNotNull().isInstanceOf(ExceptionDetails.class);
    Assertions.assertThat(response.getBody().getDetails())
        .isEqualTo("Already exists a librarian registered with this email");
    Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);

    // Verify that the librarian is registered
    Assertions.assertThat(librarianRepository.findByEmail(command.getEmail()).isPresent()).isTrue();
  }

  @Test
  @DisplayName("POST /register should return CREATED status when librarian is registered successfully")
  void postRegister_shouldReturnCreatedStatus_WhenLibrarianIsRegisteredSuccessfully() throws URISyntaxException {
    // Arrange
    RegisterLibrarianCommand command = new RegisterLibrarianCommand(
        "Bruno Lucas",
        "test@test.com",
        "Test123456",
        "male",
        LocalDate.of(2002, 2, 2),
        "123/55");

    RequestEntity<RegisterLibrarianCommand> requestEntity = getRequestEntity(
        HttpMethod.POST,
        new URI("/api/librarian/register"),
        command);

    // Act
    ResponseEntity<Void> response = restTemplate.exchange(requestEntity, Void.class);

    // Assert
    Assertions.assertThat(response).isNotNull();
    Assertions.assertThat(response.getBody()).isNull();
    Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);

    // Verify that the librarian was registered successfully
    Assertions.assertThat(librarianRepository.findByEmail(command.getEmail()).isPresent()).isTrue();
  }

  @Test
  @DisplayName("POST /register should return BAD_REQUEST status when parameters are invalid")
  void postRegister_shouldReturnBadRequestStatus_WhenParametersAreInvalid() throws URISyntaxException {
    // Arrange
    RegisterLibrarianCommand invalidCommand = new RegisterLibrarianCommand(
        null,
        null,
        null,
        null,
        null,
        null);

    RequestEntity<RegisterLibrarianCommand> requestEntity = getRequestEntity(
        HttpMethod.POST,
        new URI("/api/librarian/register"),
        invalidCommand);

    // Act
    ResponseEntity<ExceptionDetails> response = restTemplate.exchange(requestEntity, ExceptionDetails.class);

    // Assert
    Assertions.assertThat(response).isNotNull();
    Assertions.assertThat(response.getBody()).isNotNull().isInstanceOf(ExceptionDetails.class);
    Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);

    // Verify that the librarian was not registered
    Assertions.assertThat(librarianRepository.findAll().isEmpty()).isTrue();
  }

  @Test
  @SuppressWarnings("null")
  @DisplayName("POST /login should return access token when successful")
  void postLogin_shouldReturnAccessToken_WhenSuccessful() throws URISyntaxException {
    // Arrange
    String testEmail = "test@test.com";
    String testPassword = "Test123456";
    String testCrb = "123/55";

    JwtTokenService tokenService = new JwtTokenService();

    // Save an librarian with the same credentials to be able to login after
    Librarian domainLibrarian = getDomainLibrarian(testEmail, testCrb, testPassword);
    librarianRepository.saveAndFlush(LibrarianEntityMapper.toEntity(domainLibrarian));

    // Request for login using email
    RequestEntity<LoginLibrarianCommand> requestLoginEmail = getRequestEntity(
        HttpMethod.POST,
        new URI("/api/librarian/login"),
        new LoginLibrarianCommand(testEmail,
            null, testPassword));

    // Request for login using crb
    RequestEntity<LoginLibrarianCommand> requestLoginCrb = getRequestEntity(
        HttpMethod.POST,
        new URI("/api/librarian/login"),
        new LoginLibrarianCommand(null,
            testCrb, testPassword));

    // Act & Assert
    List.of(requestLoginEmail, requestLoginCrb).forEach(request -> {
      ResponseEntity<LoginLibrarianResponse> response = restTemplate.exchange(request,
          LoginLibrarianResponse.class);

      Assertions.assertThat(response).isNotNull();
      Assertions.assertThat(response.getBody()).isNotNull().isInstanceOf(LoginLibrarianResponse.class);
      Assertions.assertThat(response.getBody().getAccessToken()).isNotNull();
      Assertions.assertThat(response.getBody().getExpiresAt()).isGreaterThan(0);
      Assertions.assertThat(tokenService.isValid(response.getBody().getAccessToken())).isTrue();
      Assertions.assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    });
  }

  @Test
  @SuppressWarnings("null")
  @DisplayName("POST /login should return UNAUTHORIZED status when credentials are invalid")
  void postLogin_shouldReturnUnauthorizedStatus_WhenCredentialsAreInvalid() throws URISyntaxException {
    // Arrange
    String validEmail = "test@test.com";
    String validPassword = "Test123456";
    String validCrb = "123/55";
    String invalidEmail = "invalid@test.com";
    String invalidPassword = "Invalid123456";
    String invalidCrb = "asasa3/55";

    // Save an librarian with the valid credentials to be able to login after
    Librarian domainLibrarian = getDomainLibrarian(validEmail, validCrb, validPassword);
    librarianRepository.saveAndFlush(LibrarianEntityMapper.toEntity(domainLibrarian));

    // Request for login using invalid email
    RequestEntity<LoginLibrarianCommand> requestInvalidEmail = getRequestEntity(
        HttpMethod.POST,
        new URI("/api/librarian/login"),
        new LoginLibrarianCommand(invalidEmail,
            null, validPassword));

    // Request for login using invalid crb
    RequestEntity<LoginLibrarianCommand> requestInvalidCrb = getRequestEntity(
        HttpMethod.POST,
        new URI("/api/librarian/login"),
        new LoginLibrarianCommand(null,
            invalidCrb, validPassword));

    // Request for login using invalid email or crb
    RequestEntity<LoginLibrarianCommand> requestInvalidEmailOrCrb = getRequestEntity(
        HttpMethod.POST,
        new URI("/api/librarian/login"),
        new LoginLibrarianCommand(null,
            null, validPassword));

    // Request for login using invalid password
    RequestEntity<LoginLibrarianCommand> requestInvalidPassword = getRequestEntity(
        HttpMethod.POST,
        new URI("/api/librarian/login"),
        new LoginLibrarianCommand(validEmail,
            null, invalidPassword));

    // Act & Assert
    List.of(requestInvalidEmail, requestInvalidCrb, requestInvalidEmailOrCrb, requestInvalidPassword)
        .forEach(request -> {
          ResponseEntity<ExceptionDetails> response = restTemplate.exchange(request,
              ExceptionDetails.class);

          Assertions.assertThat(response).isNotNull();
          Assertions.assertThat(response.getBody()).isNotNull()
              .isInstanceOf(ExceptionDetails.class);
          Assertions.assertThat(response.getBody().getTitle())
              .isEqualTo("Invalid Credentials Exception");
          Assertions.assertThat(response.getStatusCode())
              .isEqualTo(HttpStatus.UNAUTHORIZED);
        });
  }

}
