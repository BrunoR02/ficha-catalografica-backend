package com.ficha.catalografica.projeto.cataloging.application.librarian.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ficha.catalografica.projeto.cataloging.application.librarian.command.LoginLibrarianCommand;
import com.ficha.catalografica.projeto.cataloging.application.librarian.command.RegisterLibrarianCommand;
import com.ficha.catalografica.projeto.cataloging.application.librarian.mapper.LibrarianMapper;
import com.ficha.catalografica.projeto.cataloging.application.librarian.response.LoginLibrarianResponse;
import com.ficha.catalografica.projeto.cataloging.domain.librarian.model.Librarian;
import com.ficha.catalografica.projeto.cataloging.domain.librarian.port.inbound.LoginLibrarianUseCase;
import com.ficha.catalografica.projeto.cataloging.domain.librarian.port.inbound.RegisterLibrarianUseCase;
import com.ficha.catalografica.projeto.common.service.JwtTokenService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/api/librarian")
@Log4j2
@RequiredArgsConstructor
public class LibrarianController {

  private final RegisterLibrarianUseCase registerLibrarianUseCase;
  private final LoginLibrarianUseCase loginLibrarianUseCase;
  private final JwtTokenService tokenService;

  @PostMapping("/register")
  public ResponseEntity<Void> registerLibrarian(@RequestBody RegisterLibrarianCommand command) {

    registerLibrarianUseCase.registerLibrarian(LibrarianMapper.toDomain(command));

    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @PostMapping("/login")
  public ResponseEntity<LoginLibrarianResponse> loginLibrarian(@RequestBody LoginLibrarianCommand command) {

    Librarian librarian = loginLibrarianUseCase.login(command.getEmail(), command.getPassword(), command.getCrb());
    log.info("Id:",librarian.getId().getValue());
    LoginLibrarianResponse response = LoginLibrarianResponse.builder()
        .accessToken(tokenService.generateToken(librarian.getId().getValue()))
        .expiresAt(tokenService.getDefaultExpirationDate().getEpochSecond())
        .build();

    return new ResponseEntity<>(response, HttpStatus.OK);
  }
}
