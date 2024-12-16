package com.ficha.catalografica.projeto.cataloging.domain.record.port.inbound;

import java.util.List;

import com.ficha.catalografica.projeto.cataloging.domain.librarian.valueobject.LibrarianId;
import com.ficha.catalografica.projeto.cataloging.domain.record.model.CatalogRecord;

public interface FindCatalogRecordsByLibrarianUseCase {

  List<CatalogRecord> findByLibrarianId(LibrarianId creatorId);

}
