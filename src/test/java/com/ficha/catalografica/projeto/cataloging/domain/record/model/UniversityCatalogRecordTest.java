package com.ficha.catalografica.projeto.cataloging.domain.record.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.ficha.catalografica.projeto.cataloging.domain.librarian.valueobject.LibrarianId;
import com.ficha.catalografica.projeto.cataloging.domain.record.valueobject.PublishingData;
import com.ficha.catalografica.projeto.cataloging.domain.record.valueobject.RecordClassification;
import com.ficha.catalografica.projeto.cataloging.domain.record.valueobject.UniversityWorkMetadata;
import com.ficha.catalografica.projeto.cataloging.domain.record.valueobject.UniversityWorkType;
import com.ficha.catalografica.projeto.cataloging.domain.record.valueobject.WorkMetadata;

@DisplayName("UniversityCatalogRecord Unit Tests")
public class UniversityCatalogRecordTest {
  @Test
  @DisplayName("constructor should throw IllegalArgumentException when arguments are invalid")
  public void constructor_shouldThrowIllegalArgumentException_whenArgumentsAreInvalid() {
    // Arrange
    LibrarianId invalidCreatorId = null;
    List<String> invalidResponsabilites = new ArrayList<>();
    WorkMetadata invalidWorkMetadata = null;
    String invalidAdvisor = " ";
    UniversityWorkMetadata invalidUniversityWorkMetadata = null;
    PublishingData invalidPublishingData = null;
    List<String> invalidSecondarySubjects = new ArrayList<>();
    RecordClassification invalidRecordClassification = null;

    LibrarianId validCreatorId = new LibrarianId();
    List<String> validResponsabilites = List.of("Bruno Santos");
    WorkMetadata validWorkMetadata = new WorkMetadata("Title", "e-book", "Subtitle", 123, false, false);
    String validAdvisor = "Dr. Roberto Carlos";
    UniversityWorkMetadata validUniversityWorkMetadata = new UniversityWorkMetadata(UniversityWorkType.GRADUATION,
        "Test", "Test", "Test", null);
    PublishingData validPublishingData = new PublishingData(LocalDate.now(), "Aracaju, SE");
    List<String> validSecondarySubjects = List.of("self development");

    // Act & Assert (invalid creatorId case)
    Assertions
        .assertThatThrownBy(
            () -> new UniversityCatalogRecord(invalidCreatorId, invalidResponsabilites, invalidWorkMetadata,
                invalidAdvisor, invalidUniversityWorkMetadata, invalidPublishingData, invalidSecondarySubjects,
                invalidRecordClassification))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("creatorId cannot be null");

    // Act & Assert (invalid responsabilities case)
    Assertions
        .assertThatThrownBy(
            () -> new UniversityCatalogRecord(validCreatorId, invalidResponsabilites, invalidWorkMetadata,
                invalidAdvisor, invalidUniversityWorkMetadata, invalidPublishingData, invalidSecondarySubjects,
                invalidRecordClassification))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("At least one responsability is required");

    // Act & Assert (invalid workMetadata case)
    Assertions
        .assertThatThrownBy(
            () -> new UniversityCatalogRecord(validCreatorId, validResponsabilites, invalidWorkMetadata,
                invalidAdvisor, invalidUniversityWorkMetadata, invalidPublishingData, invalidSecondarySubjects,
                invalidRecordClassification))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("workMetadata cannot be null");

    // Act & Assert (invalid advisor case)
    Assertions
        .assertThatThrownBy(
            () -> new UniversityCatalogRecord(validCreatorId, validResponsabilites, validWorkMetadata,
                invalidAdvisor, invalidUniversityWorkMetadata, invalidPublishingData, invalidSecondarySubjects,
                invalidRecordClassification))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("advisor cannot be null or empty");

    // Act & Assert (invalid universityWorkMetadata case)
    Assertions
        .assertThatThrownBy(
            () -> new UniversityCatalogRecord(validCreatorId, validResponsabilites, validWorkMetadata,
                validAdvisor, invalidUniversityWorkMetadata, invalidPublishingData, invalidSecondarySubjects,
                invalidRecordClassification))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("universityWorkMetadata cannot be null");

    // Act & Assert (invalid publishingData case)
    Assertions
        .assertThatThrownBy(
            () -> new UniversityCatalogRecord(validCreatorId, validResponsabilites, validWorkMetadata,
                validAdvisor, validUniversityWorkMetadata, invalidPublishingData, invalidSecondarySubjects,
                invalidRecordClassification))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("publishingData cannot be null");

    // Act & Assert (invalid secondarySubjects case)
    Assertions
        .assertThatThrownBy(
            () -> new UniversityCatalogRecord(validCreatorId, validResponsabilites, validWorkMetadata,
                validAdvisor, validUniversityWorkMetadata, validPublishingData, invalidSecondarySubjects,
                invalidRecordClassification))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("At least one secondarySubject is required");

    // Act & Assert (invalid classification case)
    Assertions
        .assertThatThrownBy(
            () -> new UniversityCatalogRecord(validCreatorId, validResponsabilites, validWorkMetadata,
                validAdvisor, validUniversityWorkMetadata, validPublishingData, validSecondarySubjects,
                invalidRecordClassification))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("classification cannot be null");
  }

  @Test
  @DisplayName("constructor should return UniversityCatalogRecord object when arguments are valid")
  public void constructor_shouldReturnUniversityCatalogRecordObject_whenArgumentsAreValid() {
    // Arrange
    LibrarianId validCreatorId = new LibrarianId();
    List<String> validResponsabilites = List.of("Bruno Santos");
    WorkMetadata validWorkMetadata = new WorkMetadata("Title", "e-book", "Subtitle", 123, false, false);
    String validAdvisor = "Dr. Roberto Carlos";
    UniversityWorkMetadata validUniversityWorkMetadata = new UniversityWorkMetadata(UniversityWorkType.GRADUATION,
        "Test", "Test", "Test", null);
    PublishingData validPublishingData = new PublishingData(LocalDate.now(), "Aracaju, SE");
    List<String> validSecondarySubjects = List.of("self development");
    RecordClassification validRecordClassification = new RecordClassification("123", "123.52", "B522m");

    // Act
    UniversityCatalogRecord universityCatalogRecord = new UniversityCatalogRecord(validCreatorId, validResponsabilites,
        validWorkMetadata, validAdvisor, validUniversityWorkMetadata, validPublishingData, validSecondarySubjects,
        validRecordClassification);

    // Assert
    Assertions.assertThat(universityCatalogRecord)
        .isNotNull()
        .isInstanceOf(UniversityCatalogRecord.class);
  }
}
