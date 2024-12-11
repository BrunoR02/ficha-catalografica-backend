package com.ficha.catalografica.projeto.librarian.application.command;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RegisterLibrarianCommand {

  private String fullName;

  private String email;

  private String password;

  private String sex;

  private LocalDate birthDate;

  private String crb;
  
}
