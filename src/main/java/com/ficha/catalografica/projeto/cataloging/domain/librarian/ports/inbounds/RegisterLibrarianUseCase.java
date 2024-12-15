package com.ficha.catalografica.projeto.cataloging.domain.librarian.ports.inbounds;

import com.ficha.catalografica.projeto.cataloging.domain.librarian.model.Librarian;

public interface RegisterLibrarianUseCase {
  
  void registerLibrarian(Librarian librarian);
}
