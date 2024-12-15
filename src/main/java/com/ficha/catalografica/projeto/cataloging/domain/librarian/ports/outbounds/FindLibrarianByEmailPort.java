package com.ficha.catalografica.projeto.cataloging.domain.librarian.ports.outbounds;

import java.util.Optional;

import com.ficha.catalografica.projeto.cataloging.domain.librarian.model.Email;
import com.ficha.catalografica.projeto.cataloging.domain.librarian.model.Librarian;

public interface FindLibrarianByEmailPort {

  Optional<Librarian> findByEmail(Email email);
}
