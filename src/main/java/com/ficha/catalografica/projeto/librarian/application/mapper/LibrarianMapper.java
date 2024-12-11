package com.ficha.catalografica.projeto.librarian.application.mapper;

import com.ficha.catalografica.projeto.librarian.application.command.RegisterLibrarianCommand;
import com.ficha.catalografica.projeto.librarian.domain.librarian.model.Librarian;
import com.ficha.catalografica.projeto.librarian.domain.librarian.model.LibrarianInfo;
import com.ficha.catalografica.projeto.librarian.domain.librarian.model.Password;
import com.ficha.catalografica.projeto.librarian.domain.librarian.model.Sex;
import com.ficha.catalografica.projeto.librarian.domain.librarian.model.Email;

public class LibrarianMapper {

  public static Librarian toDomain(RegisterLibrarianCommand command) throws IllegalArgumentException {
    LibrarianInfo info = new LibrarianInfo(command.getFullName(), Sex.parse(command.getSex()), command.getBirthDate());
    Email email = new Email(command.getEmail());
    Password password = Password.fromRaw(command.getPassword());

    return new Librarian(info, email, password, command.getCrb());
  }

}
