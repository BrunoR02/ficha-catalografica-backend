package com.ficha.catalografica.projeto.cataloging.domain.record.valueobject;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BookSeries {

  private final String name;

  private final int number;
}
