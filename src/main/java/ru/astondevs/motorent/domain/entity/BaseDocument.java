package ru.astondevs.motorent.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.astondevs.motorent.domain.entity.documents.TypeDocument;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Entity(name = "documents")
public abstract class BaseDocument extends BaseEntity {
    @Enumerated(EnumType.ORDINAL)
    private TypeDocument typeDocument;
    @Column(name = "sub_type_document")
    private String subTypeDocument;
    @Column(name = "serial")
    private String serial;
    @Column(name = "number")
    private String number;
    @Column(name = "issued_by")
    private String issuedBy;
    @Column(name = "date_of_issue")
    private LocalDate dateOfIssue;
    @Column(name = "valid_for")
    private LocalDate validFor;
}
