package com.ficha.catalografica.projeto.cataloging.domain.record.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.ficha.catalografica.projeto.cataloging.domain.librarian.valueobject.LibrarianId;
import com.ficha.catalografica.projeto.cataloging.domain.record.valueobject.BookMetadata;
import com.ficha.catalografica.projeto.cataloging.domain.record.valueobject.ISBN;
import com.ficha.catalografica.projeto.cataloging.domain.record.valueobject.PublishingData;
import com.ficha.catalografica.projeto.cataloging.domain.record.valueobject.RecordClassification;
import com.ficha.catalografica.projeto.cataloging.domain.record.valueobject.WorkMetadata;

@DisplayName("CatalogRecord Unit Tests")
public class CatalogRecordTest {

  @Test
  @DisplayName("constructor should throw IllegalArgumentException when arguments are invalid")
  public void constructor_shouldThrowIllegalArgumentException_whenArgumentsAreInvalid() {
    // Arrange
    LibrarianId invalidCreatorId = null;
    List<String> invalidResponsabilites = new ArrayList<>();
    WorkMetadata invalidWorkMetadata = null;
    PublishingData invalidPublishingData = null;
    String invalidPublisherName = " ";
    BookMetadata invalidBookMetadata = null;
    List<String> invalidSecondarySubjects = new ArrayList<>();
    RecordClassification invalidRecordClassification = null;

    LibrarianId validCreatorId = new LibrarianId();
    List<String> validResponsabilites = List.of("Bruno Santos");
    WorkMetadata validWorkMetadata = new WorkMetadata("Title", "e-book", "Subtitle", 123, false, false);
    String validTranslator = "Teste";
    PublishingData validPublishingData = new PublishingData(LocalDate.now(), "Aracaju, SE");
    String validPublisherName = "Yuukan Livros";
    List<String> validNotes = List.of("Capa dura");
    BookMetadata validBookMetadata = new BookMetadata(null, null, null, new ISBN("1234567891"));
    List<String> validSecondarySubjects = List.of("self development");

    // Act & Assert (invalid creatorId case)
    Assertions
        .assertThatThrownBy(
            () -> new CatalogRecord(invalidCreatorId, invalidResponsabilites, invalidWorkMetadata, validTranslator,
                invalidPublishingData, invalidPublisherName, invalidBookMetadata, validNotes,
                invalidSecondarySubjects, invalidRecordClassification))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("creatorId cannot be null");

    // Act & Assert (invalid responsabilities case)
    Assertions
        .assertThatThrownBy(
            () -> new CatalogRecord(validCreatorId, invalidResponsabilites, invalidWorkMetadata, validTranslator,
                invalidPublishingData, invalidPublisherName, invalidBookMetadata, validNotes,
                invalidSecondarySubjects, invalidRecordClassification))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("At least one responsability is required");

    // Act & Assert (invalid workMetadata case)
    Assertions
        .assertThatThrownBy(
            () -> new CatalogRecord(validCreatorId, validResponsabilites, invalidWorkMetadata, validTranslator,
                invalidPublishingData, invalidPublisherName, invalidBookMetadata, validNotes,
                invalidSecondarySubjects, invalidRecordClassification))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("workMetadata cannot be null");

    // Act & Assert (invalid publishingData case)
    Assertions
        .assertThatThrownBy(
            () -> new CatalogRecord(validCreatorId, validResponsabilites, validWorkMetadata, validTranslator,
                invalidPublishingData, invalidPublisherName, invalidBookMetadata, validNotes,
                invalidSecondarySubjects, invalidRecordClassification))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("publishingData cannot be null");

    // Act & Assert (invalid publisherName case)
    Assertions
        .assertThatThrownBy(
            () -> new CatalogRecord(validCreatorId, validResponsabilites, validWorkMetadata, validTranslator,
                validPublishingData, invalidPublisherName, invalidBookMetadata, validNotes,
                invalidSecondarySubjects, invalidRecordClassification))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("publisherName cannot be null or empty");

    // Act & Assert (invalid bookMetadata case)
    Assertions
        .assertThatThrownBy(
            () -> new CatalogRecord(validCreatorId, validResponsabilites, validWorkMetadata, validTranslator,
                validPublishingData, validPublisherName, invalidBookMetadata, validNotes,
                invalidSecondarySubjects, invalidRecordClassification))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("bookMetadata cannot be null");

    // Act & Assert (invalid secondarySubjects case)
    Assertions
        .assertThatThrownBy(
            () -> new CatalogRecord(validCreatorId, validResponsabilites, validWorkMetadata, validTranslator,
                validPublishingData, validPublisherName, validBookMetadata, validNotes,
                invalidSecondarySubjects, invalidRecordClassification))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("At least one secondarySubject is required");

    // Act & Assert (invalid classification case)
    Assertions
        .assertThatThrownBy(
            () -> new CatalogRecord(validCreatorId, validResponsabilites, validWorkMetadata, validTranslator,
                validPublishingData, validPublisherName, validBookMetadata, validNotes,
                validSecondarySubjects, invalidRecordClassification))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("classification cannot be null");
  }

  @Test
  @DisplayName("constructor should return CatalogRecord object when arguments are valid")
  public void constructor_shouldReturnCatalogRecordObject_whenArgumentsAreValid() {
    // Arrange
    LibrarianId validCreatorId = new LibrarianId();
    List<String> validResponsabilites = List.of("Bruno Santos");
    WorkMetadata validWorkMetadata = new WorkMetadata("Title", "e-book", "Subtitle", 123, false, false);
    String validTranslator = "Teste";
    PublishingData validPublishingData = new PublishingData(LocalDate.now(), "Aracaju, SE");
    String validPublisherName = "Yuukan Livros";
    List<String> validNotes = List.of("Capa dura");
    BookMetadata validBookMetadata = new BookMetadata(null, null, null, new ISBN("1234567891"));
    List<String> validSecondarySubjects = List.of("self development");
    RecordClassification validRecordClassification = new RecordClassification("123", "123.52", "B522m");

    // Act
    CatalogRecord catalogRecord = new CatalogRecord(validCreatorId, validResponsabilites, validWorkMetadata, validTranslator, validPublishingData, validPublisherName, validBookMetadata, validNotes, validSecondarySubjects, validRecordClassification);

    // Assert
    Assertions.assertThat(catalogRecord)
        .isNotNull()
        .isInstanceOf(CatalogRecord.class);
  }
}
