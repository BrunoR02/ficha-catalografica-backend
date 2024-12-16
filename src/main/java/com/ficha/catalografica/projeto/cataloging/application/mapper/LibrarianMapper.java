package com.ficha.catalografica.projeto.cataloging.application.mapper;

import com.ficha.catalografica.projeto.cataloging.application.command.RegisterLibrarianCommand;
import com.ficha.catalografica.projeto.cataloging.domain.librarian.model.Librarian;
import com.ficha.catalografica.projeto.cataloging.domain.librarian.valueobject.Email;
import com.ficha.catalografica.projeto.cataloging.domain.librarian.valueobject.LibrarianInfo;
import com.ficha.catalografica.projeto.cataloging.domain.librarian.valueobject.Password;
import com.ficha.catalografica.projeto.cataloging.domain.librarian.valueobject.Sex;

public class LibrarianMapper {

  public static Librarian toDomain(RegisterLibrarianCommand command) throws IllegalArgumentException {
    LibrarianInfo info = new LibrarianInfo(command.getFullName(), Sex.parse(command.getSex()), command.getBirthDate());
    Email email = new Email(command.getEmail());
    Password password = Password.fromRaw(command.getPassword());

    return new Librarian(info, email, password, command.getCrb());
  }

}
