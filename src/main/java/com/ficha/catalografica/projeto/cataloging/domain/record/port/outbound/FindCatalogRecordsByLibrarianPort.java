package com.ficha.catalografica.projeto.cataloging.domain.record.port.outbound;

import java.util.List;

import com.ficha.catalografica.projeto.cataloging.domain.librarian.valueobject.LibrarianId;
import com.ficha.catalografica.projeto.cataloging.domain.record.model.CatalogRecord;

public interface FindCatalogRecordsByLibrarianPort {

  List<CatalogRecord> findByLibrarianId(LibrarianId creatorId);
}
