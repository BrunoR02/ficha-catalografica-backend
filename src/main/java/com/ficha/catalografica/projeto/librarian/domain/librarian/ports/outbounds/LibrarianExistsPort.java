package com.ficha.catalografica.projeto.librarian.domain.librarian.ports.outbounds;

import com.ficha.catalografica.projeto.librarian.domain.librarian.model.Email;

public interface LibrarianExistsPort {
  
  boolean librarianExistsByEmail(Email email);
}
