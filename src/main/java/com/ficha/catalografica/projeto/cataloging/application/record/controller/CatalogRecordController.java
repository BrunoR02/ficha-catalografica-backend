package com.ficha.catalografica.projeto.cataloging.application.record.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ficha.catalografica.projeto.cataloging.application.record.command.CreateCatalogRecordCommand;
import com.ficha.catalografica.projeto.cataloging.application.record.dto.CatalogRecordDto;
import com.ficha.catalografica.projeto.cataloging.application.record.mapper.CatalogRecordMapper;
import com.ficha.catalografica.projeto.cataloging.domain.librarian.valueobject.LibrarianId;
import com.ficha.catalografica.projeto.cataloging.domain.record.port.inbound.CreateCatalogRecordUseCase;
import com.ficha.catalografica.projeto.cataloging.domain.record.port.inbound.FindCatalogRecordsByLibrarianUseCase;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/record")
@RequiredArgsConstructor
public class CatalogRecordController {

  private final CreateCatalogRecordUseCase createCatalogRecordUseCase;

  private final FindCatalogRecordsByLibrarianUseCase findCatalogRecordsByLibrarianUseCase;

  @PostMapping
  public ResponseEntity<Void> createCatalogRecord(@RequestBody CreateCatalogRecordCommand command) {

    createCatalogRecordUseCase.createCatalogRecord(CatalogRecordMapper.toDomain(command));

    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @GetMapping("/{creatorId}")
  public ResponseEntity<List<CatalogRecordDto>> createCatalogRecord(@PathVariable String creatorId) {

    List<CatalogRecordDto> catalogRecords = findCatalogRecordsByLibrarianUseCase
        .findByLibrarianId(new LibrarianId(creatorId))
        .stream()
        .map(catalogRecord -> CatalogRecordMapper.toDto(catalogRecord)).toList();

    return new ResponseEntity<>(catalogRecords, HttpStatus.CREATED);
  }
}
