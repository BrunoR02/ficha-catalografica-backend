package com.ficha.catalografica.projeto.cataloging.domain.record.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ficha.catalografica.projeto.cataloging.domain.librarian.valueobject.LibrarianId;
import com.ficha.catalografica.projeto.cataloging.domain.record.model.CatalogRecord;
import com.ficha.catalografica.projeto.cataloging.domain.record.model.UniversityCatalogRecord;
import com.ficha.catalografica.projeto.cataloging.domain.record.port.inbound.FindCatalogRecordsByLibrarianUseCase;
import com.ficha.catalografica.projeto.cataloging.domain.record.port.outbound.FindCatalogRecordsByLibrarianPort;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FindCatalogRecordsByLibrarianService implements FindCatalogRecordsByLibrarianUseCase {

  private final FindCatalogRecordsByLibrarianPort findCatalogRecordsByLibrarianPort;

  @Override
  public List<CatalogRecord> findCatalogRecordsByLibrarianId(LibrarianId creatorId) {

    return findCatalogRecordsByLibrarianPort.findCatalogRecordsByLibrarianId(creatorId);
  }

  @Override
  public List<UniversityCatalogRecord> findUniversityCatalogRecordsByLibrarianId(LibrarianId creatorId) {

    return findCatalogRecordsByLibrarianPort.findUniversityCatalogRecordsByLibrarianId(creatorId);
  }

}
