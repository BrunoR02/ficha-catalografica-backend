package com.ficha.catalografica.projeto.cataloging.infrastructure.record.database.adapter;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ficha.catalografica.projeto.cataloging.domain.librarian.valueobject.LibrarianId;
import com.ficha.catalografica.projeto.cataloging.domain.record.model.CatalogRecord;
import com.ficha.catalografica.projeto.cataloging.domain.record.model.UniversityCatalogRecord;
import com.ficha.catalografica.projeto.cataloging.domain.record.port.outbound.FindCatalogRecordsByLibrarianPort;
import com.ficha.catalografica.projeto.cataloging.infrastructure.record.database.mapper.CatalogRecordEntityMapper;
import com.ficha.catalografica.projeto.cataloging.infrastructure.record.database.mapper.UniversityCatalogRecordEntityMapper;
import com.ficha.catalografica.projeto.cataloging.infrastructure.record.database.repository.CatalogRecordRepository;
import com.ficha.catalografica.projeto.cataloging.infrastructure.record.database.repository.UniversityCatalogRecordRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class FindCatalogRecordsByLibrarianAdapter implements FindCatalogRecordsByLibrarianPort {

  private final CatalogRecordRepository catalogRecordRepository;
  private final UniversityCatalogRecordRepository universityCatalogRecordRepository;

  @Override
  public List<CatalogRecord> findCatalogRecordsByLibrarianId(LibrarianId creatorId) {
    return catalogRecordRepository.findAllByCreatorId(creatorId.getValue()).stream()
        .map(entity -> CatalogRecordEntityMapper.toDomain(entity)).toList();
  }

  @Override
  public List<UniversityCatalogRecord> findUniversityCatalogRecordsByLibrarianId(LibrarianId creatorId) {
    return universityCatalogRecordRepository.findAllByCreatorId(creatorId.getValue()).stream()
        .map(entity -> UniversityCatalogRecordEntityMapper.toDomain(entity)).toList();
  }

}
