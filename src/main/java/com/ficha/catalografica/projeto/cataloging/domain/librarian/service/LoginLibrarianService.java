package com.ficha.catalografica.projeto.cataloging.domain.librarian.service;

import org.springframework.stereotype.Service;

import com.ficha.catalografica.projeto.cataloging.domain.librarian.exception.InvalidCredentialsException;
import com.ficha.catalografica.projeto.cataloging.domain.librarian.model.Email;
import com.ficha.catalografica.projeto.cataloging.domain.librarian.model.Librarian;
import com.ficha.catalografica.projeto.cataloging.domain.librarian.ports.inbounds.LoginLibrarianUseCase;
import com.ficha.catalografica.projeto.cataloging.domain.librarian.ports.outbounds.FindLibrarianByCrbPort;
import com.ficha.catalografica.projeto.cataloging.domain.librarian.ports.outbounds.FindLibrarianByEmailPort;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginLibrarianService implements LoginLibrarianUseCase {

  private final FindLibrarianByEmailPort findLibrarianByEmailPort;
  private final FindLibrarianByCrbPort findLibrarianByCrbPort;

  @Override
  public Librarian login(String emailValue, String passwordValue, String crb)
      throws IllegalArgumentException, InvalidCredentialsException {

    Librarian foundLibrarian = null;

    String foundBy = "email";

    if (emailValue != null) {
      Email email = new Email(emailValue);

      foundLibrarian = findLibrarianByEmailPort.findByEmail(email)
          .orElseThrow(() -> new InvalidCredentialsException("Invalid email or password"));
    } else if (crb != null) {
      foundLibrarian = findLibrarianByCrbPort.findByCrb(crb)
          .orElseThrow(() -> new InvalidCredentialsException("Invalid crb or password"));

      foundBy = "crb";
    }

    if (foundLibrarian == null)
      throw new InvalidCredentialsException("email or crb is required");

    if (!foundLibrarian.getPassword().matches(passwordValue))
      throw new InvalidCredentialsException(String.format("Invalid %s or password", foundBy));

    return foundLibrarian;
  }

}
