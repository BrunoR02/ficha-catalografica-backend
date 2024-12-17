package com.ficha.catalografica.projeto.cataloging.infrastructure.librarian.database.mapper;

import com.ficha.catalografica.projeto.cataloging.domain.librarian.model.Librarian;
import com.ficha.catalografica.projeto.cataloging.domain.librarian.valueobject.Email;
import com.ficha.catalografica.projeto.cataloging.domain.librarian.valueobject.LibrarianId;
import com.ficha.catalografica.projeto.cataloging.domain.librarian.valueobject.LibrarianInfo;
import com.ficha.catalografica.projeto.cataloging.domain.librarian.valueobject.Password;
import com.ficha.catalografica.projeto.cataloging.infrastructure.librarian.database.entity.LibrarianEntity;

public class LibrarianEntityMapper {

  public static LibrarianEntity toEntity(Librarian librarian) {
    return LibrarianEntity.builder()
        .id(librarian.getId().getValue())
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
        .id(new LibrarianId(entity.getId()))
        .email(new Email(entity.getEmail()))
        .password(new Password(entity.getPassword()))
        .crb(entity.getCrb())
        .librarianInfo(info)
        .registeredAt(entity.getRegisteredAt())
        .updatedAt(entity.getUpdatedAt())
        .build();
  }

}
