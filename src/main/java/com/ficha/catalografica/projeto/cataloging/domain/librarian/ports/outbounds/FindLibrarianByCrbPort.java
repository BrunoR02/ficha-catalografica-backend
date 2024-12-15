package com.ficha.catalografica.projeto.cataloging.domain.librarian.ports.outbounds;

import java.util.Optional;

import com.ficha.catalografica.projeto.cataloging.domain.librarian.model.Librarian;

public interface FindLibrarianByCrbPort {

  Optional<Librarian> findByCrb(String crb);
}
