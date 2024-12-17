package com.ficha.catalografica.projeto.cataloging.domain.record.port.outbound;

import java.util.List;

import com.ficha.catalografica.projeto.cataloging.domain.librarian.valueobject.LibrarianId;
import com.ficha.catalografica.projeto.cataloging.domain.record.model.CatalogRecord;
import com.ficha.catalografica.projeto.cataloging.domain.record.model.UniversityCatalogRecord;

public interface FindCatalogRecordsByLibrarianPort {

  List<CatalogRecord> findCatalogRecordsByLibrarianId(LibrarianId creatorId);

  List<UniversityCatalogRecord> findUniversityCatalogRecordsByLibrarianId(LibrarianId creatorId);
}
