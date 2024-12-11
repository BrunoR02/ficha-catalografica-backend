package com.ficha.catalografica.projeto.librarian.application.command;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginLibrarianCommand {

  private String email;
  
  private String crb;

  private String password;
  
}
