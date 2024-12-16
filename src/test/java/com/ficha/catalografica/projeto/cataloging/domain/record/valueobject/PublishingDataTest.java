package com.ficha.catalografica.projeto.cataloging.domain.record.valueobject;

import java.time.LocalDate;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("PublishingData Unit Tests")
public class PublishingDataTest {

  @Test
  @DisplayName("constructor should throw IllegalArgumentException when arguments are invalid")
  public void constructor_shouldThrowIllegalArgumentException_whenArgumentsAreInvalid() {
    // Arrange
    LocalDate invalidDate = null;
    LocalDate validDate = LocalDate.now();
    String invalidLocation = null;

    // Act & Assert (invalid date case)
    Assertions
        .assertThatThrownBy(() -> new PublishingData(invalidDate, invalidLocation))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("date cannot be null");

    // Act & Assert (invalid location case)
    Assertions
        .assertThatThrownBy(() -> new PublishingData(validDate, invalidLocation))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("location cannot be null or empty");
  }

  @Test
  @DisplayName("constructor should return PublishingData object when arguments are valid")
  public void constructor_shouldReturnPublishingDataObject_whenArgumentsAreValid() {
    // Arrange
    LocalDate validDate = LocalDate.now();
    String validLocation = "Aracaju, SE";

    // Act
    PublishingData publishingData = new PublishingData(validDate, validLocation);

    // Assert
    Assertions.assertThat(publishingData)
        .isNotNull()
        .isInstanceOf(PublishingData.class);
  }
}
