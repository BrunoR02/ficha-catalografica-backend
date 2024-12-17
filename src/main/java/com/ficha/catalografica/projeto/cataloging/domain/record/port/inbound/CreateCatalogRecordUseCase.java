package com.ficha.catalografica.projeto.cataloging.domain.record.port.inbound;

import com.ficha.catalografica.projeto.cataloging.domain.record.model.CatalogRecord;
import com.ficha.catalografica.projeto.cataloging.domain.record.model.UniversityCatalogRecord;

public interface CreateCatalogRecordUseCase {

  void createCatalogRecord(CatalogRecord catalogRecord);
  
  void createUniversityCatalogRecord(UniversityCatalogRecord universityCatalogRecord);
}
