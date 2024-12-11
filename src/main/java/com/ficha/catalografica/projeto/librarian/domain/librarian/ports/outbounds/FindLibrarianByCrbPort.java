package com.ficha.catalografica.projeto.librarian.domain.librarian.ports.outbounds;

import java.util.Optional;

import com.ficha.catalografica.projeto.librarian.domain.librarian.model.Librarian;

public interface FindLibrarianByCrbPort {

  Optional<Librarian> findByCrb(String crb);
}
