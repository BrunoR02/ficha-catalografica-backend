package com.ficha.catalografica.projeto.cataloging.infrastructure.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ficha.catalografica.projeto.cataloging.infrastructure.database.entity.LibrarianEntity;

import java.util.Optional;

public interface LibrarianRepository extends JpaRepository<LibrarianEntity, String> {

  Optional<LibrarianEntity> findByEmail(String email);

  Optional<LibrarianEntity> findByCrb(String crb);
}