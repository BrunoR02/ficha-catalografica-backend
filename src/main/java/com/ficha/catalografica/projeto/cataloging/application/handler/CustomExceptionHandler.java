package com.ficha.catalografica.projeto.cataloging.application.handler;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ficha.catalografica.projeto.cataloging.domain.librarian.exception.EntityExistsException;
import com.ficha.catalografica.projeto.cataloging.domain.librarian.exception.InvalidCredentialsException;
import com.ficha.catalografica.projeto.common.exception.ExceptionDetails;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler({ EntityExistsException.class })
  protected ResponseEntity<ExceptionDetails> handleEntityExistsException(EntityExistsException exception) {

    ExceptionDetails exceptionDetails = ExceptionDetails.builder()
        .title(exception.getTitle())
        .status(exception.getStatusCode().value())
        .details(exception.getMessage())
        .developerMessage(exception.getClass().getName())
        .timestamp(LocalDateTime.now().toString())
        .build();

    return new ResponseEntity<>(exceptionDetails, exception.getStatusCode());
  }

  @ExceptionHandler({ InvalidCredentialsException.class })
  protected ResponseEntity<ExceptionDetails> handleInvalidCredentialsException(InvalidCredentialsException exception) {

    ExceptionDetails exceptionDetails = ExceptionDetails.builder()
        .title(exception.getTitle())
        .status(exception.getStatusCode().value())
        .details(exception.getMessage())
        .developerMessage(exception.getClass().getName())
        .timestamp(LocalDateTime.now().toString())
        .build();

    return new ResponseEntity<>(exceptionDetails, exception.getStatusCode());
  }

  @ExceptionHandler({ IllegalArgumentException.class })
  protected ResponseEntity<ExceptionDetails> handleIllegalArgumentException(Exception exception) {

    ExceptionDetails exceptionDetails = ExceptionDetails.builder()
        .title("Illegal Argument Exception")
        .status(HttpStatus.BAD_REQUEST.value())
        .details(exception.getMessage())
        .developerMessage(exception.getClass().getName())
        .timestamp(LocalDateTime.now().toString())
        .build();

    return new ResponseEntity<>(exceptionDetails, HttpStatus.BAD_REQUEST);
  }

  @Override
  @SuppressWarnings("null")
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
      HttpHeaders headers, HttpStatusCode status, WebRequest request) {

    ExceptionDetails exceptionDetails = ExceptionDetails.builder()
        .title("Method Argument Not Valid Exception")
        .status(HttpStatus.BAD_REQUEST.value())
        .details(exception.getMessage())
        .developerMessage(exception.getClass().getName())
        .timestamp(LocalDateTime.now().toString())
        .build();

    return new ResponseEntity<>(exceptionDetails, HttpStatus.BAD_REQUEST);
  }

  @Override
  @SuppressWarnings("null")
  protected ResponseEntity<Object> handleExceptionInternal(Exception exception, Object arg1, HttpHeaders headers,
      HttpStatusCode status, WebRequest request) {

    ExceptionDetails exceptionDetails = ExceptionDetails.builder()
        .title("Bad Request Exception")
        .status(HttpStatus.BAD_REQUEST.value())
        .details(exception.getMessage())
        .developerMessage(exception.getClass().getName())
        .timestamp(LocalDateTime.now().toString())
        .build();

    return new ResponseEntity<>(exceptionDetails, HttpStatus.BAD_REQUEST);
  }

}
