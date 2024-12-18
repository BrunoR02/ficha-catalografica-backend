package com.ficha.catalografica.projeto.cataloging.infrastructure.librarian.database.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.ficha.catalografica.projeto.cataloging.domain.librarian.valueobject.Sex;

@Getter
@Builder
@AllArgsConstructor
@Entity
@ToString
@Table(name = "librarians", indexes = {
    @Index(columnList = "email", name = "idx_email")
})
public class LibrarianEntity {

  @Id
  @Column(name = "id")
  private String id;

  private String fullName;

  @Enumerated(EnumType.STRING)
  private Sex sex;

  private LocalDate birthDate;

  private String email;

  private String password;

  private LocalDateTime registeredAt;

  private LocalDateTime updatedAt;

  private String crb;

  LibrarianEntity() {
  }
}
