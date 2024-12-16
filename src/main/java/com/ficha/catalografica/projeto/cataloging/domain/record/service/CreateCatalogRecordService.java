package com.ficha.catalografica.projeto.cataloging.domain.record.service;

import org.springframework.stereotype.Service;

import com.ficha.catalografica.projeto.cataloging.domain.record.model.CatalogRecord;
import com.ficha.catalografica.projeto.cataloging.domain.record.port.inbound.CreateCatalogRecordUseCase;
import com.ficha.catalografica.projeto.cataloging.domain.record.port.outbound.CreateCatalogRecordPort;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CreateCatalogRecordService implements CreateCatalogRecordUseCase {

  private final CreateCatalogRecordPort createCatalogRecordPort;

  @Override
  public void createCatalogRecord(CatalogRecord catalogRecord) {

    createCatalogRecordPort.createCatalogRecord(catalogRecord);
  }

}
