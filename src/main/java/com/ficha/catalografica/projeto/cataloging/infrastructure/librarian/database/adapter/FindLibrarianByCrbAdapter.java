package com.ficha.catalografica.projeto.cataloging.infrastructure.librarian.database.adapter;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.ficha.catalografica.projeto.cataloging.domain.librarian.model.Librarian;
import com.ficha.catalografica.projeto.cataloging.domain.librarian.port.outbound.FindLibrarianByCrbPort;
import com.ficha.catalografica.projeto.cataloging.infrastructure.librarian.database.mapper.LibrarianEntityMapper;
import com.ficha.catalografica.projeto.cataloging.infrastructure.librarian.database.repository.LibrarianRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class FindLibrarianByCrbAdapter implements FindLibrarianByCrbPort {

  private final LibrarianRepository librarianRepository;

  @Override
  public Optional<Librarian> findByCrb(String crb) {
    return librarianRepository.findByCrb(crb).map(entity -> LibrarianEntityMapper.toDomain(entity));
  }
}
