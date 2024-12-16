package com.ficha.catalografica.projeto.cataloging.domain.librarian.port.outbound;

import com.ficha.catalografica.projeto.cataloging.domain.librarian.valueobject.Email;

public interface LibrarianExistsPort {
  
  boolean librarianExistsByEmail(Email email);
}
