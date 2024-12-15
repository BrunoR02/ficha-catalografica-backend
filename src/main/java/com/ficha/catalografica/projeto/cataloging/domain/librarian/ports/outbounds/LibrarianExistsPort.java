package com.ficha.catalografica.projeto.cataloging.domain.librarian.ports.outbounds;

import com.ficha.catalografica.projeto.cataloging.domain.librarian.model.Email;

public interface LibrarianExistsPort {
  
  boolean librarianExistsByEmail(Email email);
}
