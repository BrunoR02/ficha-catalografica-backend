package com.ficha.catalografica.projeto.librarian.infrastructure.database.mapper;

import com.ficha.catalografica.projeto.librarian.domain.librarian.model.Email;
import com.ficha.catalografica.projeto.librarian.domain.librarian.model.Librarian;
import com.ficha.catalografica.projeto.librarian.domain.librarian.model.LibrarianId;
import com.ficha.catalografica.projeto.librarian.domain.librarian.model.LibrarianInfo;
import com.ficha.catalografica.projeto.librarian.domain.librarian.model.Password;
import com.ficha.catalografica.projeto.librarian.infrastructure.database.entity.LibrarianEntity;

public class LibrarianEntityMapper {

  public static LibrarianEntity toEntity(Librarian librarian) {
    return LibrarianEntity.builder()
        .librarianId(librarian.getId().getValue())
        .email(librarian.getEmail().getValue())
        .password(librarian.getPassword().getHashedValue())
        .crb(librarian.getCrb())
        .fullName(librarian.getLibrarianInfo().getFullName())
        .sex(librarian.getLibrarianInfo().getSex())
        .registeredAt(librarian.getRegisteredAt())
        .updatedAt(librarian.getUpdatedAt())
        .birthDate(librarian.getLibrarianInfo().getBirthDate())
        .build();
  }

  public static Librarian toDomain(LibrarianEntity entity) throws IllegalArgumentException {
    LibrarianInfo info = new LibrarianInfo(entity.getFullName(), entity.getSex(), entity.getBirthDate());

    return Librarian.builder()
        .id(new LibrarianId(entity.getLibrarianId()))
        .email(new Email(entity.getEmail()))
        .password(new Password(entity.getPassword()))
        .crb(entity.getCrb())
        .librarianInfo(info)
        .registeredAt(entity.getRegisteredAt())
        .updatedAt(entity.getUpdatedAt())
        .build();
  }

}
