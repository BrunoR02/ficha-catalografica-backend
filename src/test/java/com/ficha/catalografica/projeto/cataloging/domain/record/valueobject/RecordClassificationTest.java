package com.ficha.catalografica.projeto.cataloging.domain.record.valueobject;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("RecordClassification Unit Tests")
public class RecordClassificationTest {

  @Test
  @DisplayName("constructor should throw IllegalArgumentException when arguments are invalid")
  public void constructor_shouldThrowIllegalArgumentException_whenArgumentsAreInvalid() {
    // Arrange
    String invalidCdd = "";
    String invalidCdu = " ";
    String invalidCutter = " ";
    String validCdd = "123/5";
    String validCdu = "456.55";

    // Act & Assert (invalid cdd/cdu case)
    Assertions
        .assertThatThrownBy(() -> new RecordClassification(invalidCdd, invalidCdu, invalidCutter))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("cdd or cdu is required");

    // Act & Assert (invalid cutter case)
    Assertions
        .assertThatThrownBy(() -> new RecordClassification(validCdd, validCdu, invalidCutter))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("cutter cannot be null or empty");
  }

  @Test
  @DisplayName("constructor should return RecordClassification object when arguments are valid")
  public void constructor_shouldReturnRecordClassificationObject_whenArgumentsAreValid() {
    // Arrange
    String validCdd = "123/5";
    String validCdu = "456.55";
    String validCutter = "A125m";

    // Act
    RecordClassification recordClassification = new RecordClassification(validCdd, validCdu, validCutter);

    // Assert
    Assertions.assertThat(recordClassification)
        .isNotNull()
        .isInstanceOf(RecordClassification.class);
  }
}
