package com.ficha.catalografica.projeto.cataloging.domain.record.port.inbound;

import com.ficha.catalografica.projeto.cataloging.domain.record.model.CatalogRecord;

public interface CreateCatalogRecordUseCase {

  void createCatalogRecord(CatalogRecord catalogRecord);
}
