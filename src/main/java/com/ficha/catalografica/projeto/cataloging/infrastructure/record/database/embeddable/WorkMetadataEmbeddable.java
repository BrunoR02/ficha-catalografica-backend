package com.ficha.catalografica.projeto.cataloging.infrastructure.record.database.embeddable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
@Embeddable
public class WorkMetadataEmbeddable {

  @Column(table = "cr_work_metadata")
  private String title;

  @Column(table = "cr_work_metadata")
  private String format;

  @Column(table = "cr_work_metadata")
  private String subtitle;

  @Column(table = "cr_work_metadata")
  private int pages;

  @Column(name = "has_illustration", table = "cr_work_metadata")
  private boolean hasIllustration;

  @Column(name = "has_color", table = "cr_work_metadata")
  private boolean hasColor;
  

  public boolean hasIllustration() {
    return hasIllustration;
  }

  public boolean hasColor() {
    return hasColor;
  }

}
