package com.ficha.catalografica.projeto.librarian.domain.librarian.ports.inbounds;

import com.ficha.catalografica.projeto.librarian.domain.librarian.model.Librarian;

public interface LoginLibrarianUseCase {
  
  Librarian login(String emailValue, String passwordValue, String crb);
}
