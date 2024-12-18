package com.ficha.catalografica.projeto.cataloging.infrastructure.librarian.database.adapter;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.ficha.catalografica.projeto.cataloging.domain.librarian.model.Librarian;
import com.ficha.catalografica.projeto.cataloging.domain.librarian.port.outbound.FindLibrarianByEmailPort;
import com.ficha.catalografica.projeto.cataloging.domain.librarian.valueobject.Email;
import com.ficha.catalografica.projeto.cataloging.infrastructure.librarian.database.mapper.LibrarianEntityMapper;
import com.ficha.catalografica.projeto.cataloging.infrastructure.librarian.database.repository.LibrarianRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class FindLibrarianByEmailAdapter implements FindLibrarianByEmailPort {

  private final LibrarianRepository librarianRepository;

  @Override
  public Optional<Librarian> findByEmail(Email email) {
    
    return librarianRepository.findByEmail(email.getValue()).map(entity -> LibrarianEntityMapper.toDomain(entity));
  }
}
