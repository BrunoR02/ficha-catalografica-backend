package com.ficha.catalografica.projeto.librarian.infrastructure.database.adapter;

import org.springframework.stereotype.Repository;

import com.ficha.catalografica.projeto.librarian.domain.librarian.model.Email;
import com.ficha.catalografica.projeto.librarian.domain.librarian.ports.outbounds.LibrarianExistsPort;
import com.ficha.catalografica.projeto.librarian.infrastructure.database.repository.LibrarianRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class LibrarianExistsAdapter implements LibrarianExistsPort {

  private final LibrarianRepository librarianRepository;

  @Override
  public boolean librarianExistsByEmail(Email email) {
    return librarianRepository.findByEmail(email.getValue()).isPresent();
  }

}
