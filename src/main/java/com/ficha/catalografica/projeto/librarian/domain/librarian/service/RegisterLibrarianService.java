package com.ficha.catalografica.projeto.librarian.domain.librarian.service;

import org.springframework.stereotype.Service;

import com.ficha.catalografica.projeto.librarian.domain.librarian.exception.AlreadyExistsException;
import com.ficha.catalografica.projeto.librarian.domain.librarian.model.Librarian;
import com.ficha.catalografica.projeto.librarian.domain.librarian.ports.inbounds.RegisterLibrarianUseCase;
import com.ficha.catalografica.projeto.librarian.domain.librarian.ports.outbounds.LibrarianExistsPort;
import com.ficha.catalografica.projeto.librarian.domain.librarian.ports.outbounds.RegisterLibrarianPort;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class RegisterLibrarianService implements RegisterLibrarianUseCase {

  private final RegisterLibrarianPort registerLibrarianPort;
  private final LibrarianExistsPort librarianExistsPort;

  @Override
  public void registerLibrarian(Librarian librarian) {

    if (librarianExistsPort.librarianExistsByEmail(librarian.getEmail()))
      throw new AlreadyExistsException("Already exists a librarian registered with this email");

    registerLibrarianPort.registerLibrarian(librarian);
  }

}
