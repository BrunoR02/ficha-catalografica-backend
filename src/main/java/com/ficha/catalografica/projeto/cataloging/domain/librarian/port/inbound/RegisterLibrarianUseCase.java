package com.ficha.catalografica.projeto.cataloging.domain.librarian.port.inbound;

import com.ficha.catalografica.projeto.cataloging.domain.librarian.model.Librarian;

public interface RegisterLibrarianUseCase {
  
  void registerLibrarian(Librarian librarian);
}
