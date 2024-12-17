package com.ficha.catalografica.projeto.cataloging.application.librarian.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;

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

import com.ficha.catalografica.projeto.cataloging.application.librarian.command.RegisterLibrarianCommand;
import com.ficha.catalografica.projeto.cataloging.infrastructure.librarian.database.repository.LibrarianRepository;
import com.ficha.catalografica.projeto.common.exception.ExceptionDetails;

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
  void init() {
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
    Assertions.assertThat(librarianRepository.findByEmail(invalidCommand.getEmail()).isEmpty()).isTrue();
  }

}
