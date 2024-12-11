package com.ficha.catalografica.projeto.librarian.application.command;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UpdateLibrarianCommand {

  private String fullName;

  private String email;

  private String sex;

  private LocalDate birthDate;

  private String crb;
  
}
