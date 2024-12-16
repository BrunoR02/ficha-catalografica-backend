package com.ficha.catalografica.projeto.cataloging.infrastructure.database.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

import com.ficha.catalografica.projeto.cataloging.domain.librarian.valueobject.Sex;

@Getter
@Builder
@AllArgsConstructor
@Entity
@Table(name = "librarians")
public class LibrarianEntity {

  @EmbeddedId
  @Column(name = "id")
  private String librarianId;

  private String fullName;

  @Enumerated(EnumType.STRING)
  private Sex sex;

  private LocalDate birthDate;

  private String email;

  private String password;

  private LocalDate registeredAt;

  private LocalDate updatedAt;

  private String crb;

  LibrarianEntity() {
  }
}
