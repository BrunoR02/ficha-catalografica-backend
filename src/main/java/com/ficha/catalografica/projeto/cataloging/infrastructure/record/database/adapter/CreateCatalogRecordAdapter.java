package com.ficha.catalografica.projeto.cataloging.infrastructure.record.database.adapter;

import org.springframework.stereotype.Repository;

import com.ficha.catalografica.projeto.cataloging.domain.record.model.CatalogRecord;
import com.ficha.catalografica.projeto.cataloging.domain.record.model.UniversityCatalogRecord;
import com.ficha.catalografica.projeto.cataloging.domain.record.port.outbound.CreateCatalogRecordPort;
import com.ficha.catalografica.projeto.cataloging.infrastructure.record.database.mapper.CatalogRecordEntityMapper;
import com.ficha.catalografica.projeto.cataloging.infrastructure.record.database.mapper.UniversityCatalogRecordEntityMapper;
import com.ficha.catalografica.projeto.cataloging.infrastructure.record.database.repository.CatalogRecordRepository;
import com.ficha.catalografica.projeto.cataloging.infrastructure.record.database.repository.UniversityCatalogRecordRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class CreateCatalogRecordAdapter implements CreateCatalogRecordPort {

  private final CatalogRecordRepository catalogRecordRepository;
  private final UniversityCatalogRecordRepository universityCatalogRecordRepository;

  @Override
  public void createCatalogRecord(CatalogRecord catalogRecord) {

    catalogRecordRepository.save(CatalogRecordEntityMapper.toEntity(catalogRecord));
  }

  @Override
  public void createUniversityCatalogRecord(UniversityCatalogRecord universityCatalogRecord) {

    universityCatalogRecordRepository.save(UniversityCatalogRecordEntityMapper.toEntity(universityCatalogRecord));
  }

}
