package com.ficha.catalografica.projeto.common.exception;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ExceptionDetails {

  private String title;

  private int status;

  private String timestamp;

  private String details;

  @JsonProperty(value = "developer_message")
  private String developerMessage;

}
