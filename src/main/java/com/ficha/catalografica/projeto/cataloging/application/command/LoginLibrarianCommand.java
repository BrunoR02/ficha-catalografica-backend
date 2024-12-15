package com.ficha.catalografica.projeto.cataloging.application.command;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginLibrarianCommand {

  private String email;
  
  private String crb;

  private String password;
  
}
