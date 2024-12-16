package com.ficha.catalografica.projeto.cataloging.domain.record.valueobject;

import java.util.UUID;

import lombok.Getter;

@Getter
public class CatalogRecordId {

  private final String value;

  public CatalogRecordId(String value) {
    this.value = value;
  }

  public CatalogRecordId() {
    this.value = UUID.randomUUID().toString();
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((value == null) ? 0 : value.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    CatalogRecordId other = (CatalogRecordId) obj;
    if (value == null) {
      if (other.value != null)
        return false;
    } else if (!value.equals(other.value))
      return false;
    return true;
  }
}
