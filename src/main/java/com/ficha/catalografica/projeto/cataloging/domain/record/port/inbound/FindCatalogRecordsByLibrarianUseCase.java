package com.ficha.catalografica.projeto.cataloging.domain.record.port.inbound;

import java.util.List;

import com.ficha.catalografica.projeto.cataloging.domain.librarian.valueobject.LibrarianId;
import com.ficha.catalografica.projeto.cataloging.domain.record.model.CatalogRecord;
import com.ficha.catalografica.projeto.cataloging.domain.record.model.UniversityCatalogRecord;

public interface FindCatalogRecordsByLibrarianUseCase {

  List<CatalogRecord> findCatalogRecordsByLibrarianId(LibrarianId creatorId);

  List<UniversityCatalogRecord> findUniversityCatalogRecordsByLibrarianId(LibrarianId creatorId);

}
