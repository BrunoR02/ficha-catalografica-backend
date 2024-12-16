package com.ficha.catalografica.projeto.cataloging.domain.librarian.ports.outbounds;

import java.util.Optional;

import com.ficha.catalografica.projeto.cataloging.domain.librarian.model.Librarian;
import com.ficha.catalografica.projeto.cataloging.domain.librarian.valueobject.Email;

public interface FindLibrarianByEmailPort {

  Optional<Librarian> findByEmail(Email email);
}
