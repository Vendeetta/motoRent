package ru.astondevs.motorent.domain.entity.documents;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import ru.astondevs.motorent.domain.entity.BaseEntity;

import java.time.LocalDate;

@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@Table(name = "documents")
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
