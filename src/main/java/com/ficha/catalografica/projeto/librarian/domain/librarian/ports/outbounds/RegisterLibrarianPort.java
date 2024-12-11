package com.ficha.catalografica.projeto.librarian.domain.librarian.ports.outbounds;

import com.ficha.catalografica.projeto.librarian.domain.librarian.model.Librarian;

public interface RegisterLibrarianPort {
  
  void registerLibrarian(Librarian librarian);
}
