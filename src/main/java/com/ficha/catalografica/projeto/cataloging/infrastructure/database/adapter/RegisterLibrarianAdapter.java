package com.ficha.catalografica.projeto.cataloging.infrastructure.database.adapter;

import org.springframework.stereotype.Repository;

import com.ficha.catalografica.projeto.cataloging.domain.librarian.model.Librarian;
import com.ficha.catalografica.projeto.cataloging.domain.librarian.port.outbound.RegisterLibrarianPort;
import com.ficha.catalografica.projeto.cataloging.infrastructure.database.mapper.LibrarianEntityMapper;
import com.ficha.catalografica.projeto.cataloging.infrastructure.database.repository.LibrarianRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class RegisterLibrarianAdapter implements RegisterLibrarianPort {

  private final LibrarianRepository librarianRepository;

  @Override
  public void registerLibrarian(Librarian librarian) {

    librarianRepository.save(LibrarianEntityMapper.toEntity(librarian));
  }

}
