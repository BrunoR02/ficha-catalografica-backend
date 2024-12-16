package com.ficha.catalografica.projeto.cataloging.domain.librarian.port.inbound;

import com.ficha.catalografica.projeto.cataloging.domain.librarian.model.Librarian;

public interface LoginLibrarianUseCase {
  
  Librarian login(String emailValue, String passwordValue, String crb);
}
