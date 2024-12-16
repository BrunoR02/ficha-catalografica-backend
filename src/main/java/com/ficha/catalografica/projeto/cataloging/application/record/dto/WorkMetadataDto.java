package com.ficha.catalografica.projeto.cataloging.application.record.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class WorkMetadataDto {
  
  private String title;

  private String format;

  private String subtitle;

  private int pages;

  private boolean hasIllustration;

  private boolean hasColor;

  public boolean hasIllustration(){
    return hasIllustration;
  }

  public boolean hasColor(){
    return hasColor;
  }
  
}
