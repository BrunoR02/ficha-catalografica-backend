package com.ficha.catalografica.projeto.librarian.infrastructure.database.adapter;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.ficha.catalografica.projeto.librarian.domain.librarian.model.Email;
import com.ficha.catalografica.projeto.librarian.domain.librarian.model.Librarian;
import com.ficha.catalografica.projeto.librarian.domain.librarian.ports.outbounds.FindLibrarianByEmailPort;
import com.ficha.catalografica.projeto.librarian.infrastructure.database.mapper.LibrarianEntityMapper;
import com.ficha.catalografica.projeto.librarian.infrastructure.database.repository.LibrarianRepository;

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