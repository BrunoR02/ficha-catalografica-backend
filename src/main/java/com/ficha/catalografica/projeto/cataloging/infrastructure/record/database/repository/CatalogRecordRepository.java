package com.ficha.catalografica.projeto.cataloging.infrastructure.record.database.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ficha.catalografica.projeto.cataloging.infrastructure.record.database.entity.CatalogRecordEntity;

public interface CatalogRecordRepository extends JpaRepository<CatalogRecordEntity, String> {

  List<CatalogRecordEntity> findAllByCreatorId(String creatorId);
}
