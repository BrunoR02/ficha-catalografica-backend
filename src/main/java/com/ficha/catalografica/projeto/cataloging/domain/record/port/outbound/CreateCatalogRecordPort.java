package com.ficha.catalografica.projeto.cataloging.domain.record.port.outbound;

import com.ficha.catalografica.projeto.cataloging.domain.record.model.CatalogRecord;
import com.ficha.catalografica.projeto.cataloging.domain.record.model.UniversityCatalogRecord;

public interface CreateCatalogRecordPort {

  void createCatalogRecord(CatalogRecord catalogRecord);
  
  void createUniversityCatalogRecord(UniversityCatalogRecord universityCatalogRecord);

}
