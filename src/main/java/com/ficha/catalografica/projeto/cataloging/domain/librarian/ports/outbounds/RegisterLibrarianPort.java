package com.ficha.catalografica.projeto.cataloging.domain.librarian.ports.outbounds;

import com.ficha.catalografica.projeto.cataloging.domain.librarian.model.Librarian;

public interface RegisterLibrarianPort {
  
  void registerLibrarian(Librarian librarian);
}
