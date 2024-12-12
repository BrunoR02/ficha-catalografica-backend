package com.ficha.catalografica.projeto.librarian.application.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ficha.catalografica.projeto.common.service.TokenService;
import com.ficha.catalografica.projeto.librarian.application.command.LoginLibrarianCommand;
import com.ficha.catalografica.projeto.librarian.application.command.RegisterLibrarianCommand;
import com.ficha.catalografica.projeto.librarian.application.mapper.LibrarianMapper;
import com.ficha.catalografica.projeto.librarian.application.response.LoginLibrarianResponse;
import com.ficha.catalografica.projeto.librarian.domain.librarian.model.Librarian;
import com.ficha.catalografica.projeto.librarian.domain.librarian.ports.inbounds.LoginLibrarianUseCase;
import com.ficha.catalografica.projeto.librarian.domain.librarian.ports.inbounds.RegisterLibrarianUseCase;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/librarian")
@RequiredArgsConstructor
public class LibrarianController {

  private final RegisterLibrarianUseCase registerLibrarianUseCase;
  private final LoginLibrarianUseCase loginLibrarianUseCase;
  private final TokenService tokenService;

  @PostMapping("/register")
  public ResponseEntity<Void> registerLibrarian(@RequestBody RegisterLibrarianCommand command) {

    registerLibrarianUseCase.registerLibrarian(LibrarianMapper.toDomain(command));

    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @PostMapping("/login")
  public ResponseEntity<LoginLibrarianResponse> loginLibrarian(@RequestBody LoginLibrarianCommand command) {

    Librarian librarian = loginLibrarianUseCase.login(command.getEmail(), command.getPassword(), command.getCrb());
    LoginLibrarianResponse response = LoginLibrarianResponse.builder()
        .accessToken(tokenService.generateToken(librarian.getId().getValue()))
        .expiresAt(tokenService.getDefaultExpirationDate().getEpochSecond())
        .build();

    return new ResponseEntity<>(response, HttpStatus.OK);
  }
}
