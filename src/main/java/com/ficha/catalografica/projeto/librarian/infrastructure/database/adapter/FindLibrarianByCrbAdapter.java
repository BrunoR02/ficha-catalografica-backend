package com.ficha.catalografica.projeto.librarian.infrastructure.database.adapter;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.ficha.catalografica.projeto.librarian.domain.librarian.model.Librarian;
import com.ficha.catalografica.projeto.librarian.domain.librarian.ports.outbounds.FindLibrarianByCrbPort;
import com.ficha.catalografica.projeto.librarian.infrastructure.database.mapper.LibrarianEntityMapper;
import com.ficha.catalografica.projeto.librarian.infrastructure.database.repository.LibrarianRepository;

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