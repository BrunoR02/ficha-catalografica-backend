package com.ficha.catalografica.projeto.librarian.domain.librarian.ports.inbounds;

import com.ficha.catalografica.projeto.librarian.domain.librarian.model.Librarian;

public interface RegisterLibrarianUseCase {
  
  void registerLibrarian(Librarian librarian);
}
