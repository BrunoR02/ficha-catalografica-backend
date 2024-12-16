package com.ficha.catalografica.projeto.cataloging.domain.record.port.outbound;

import com.ficha.catalografica.projeto.cataloging.domain.record.model.CatalogRecord;

public interface CreateCatalogRecordPort {

  void createCatalogRecord(CatalogRecord catalogRecord);

}
