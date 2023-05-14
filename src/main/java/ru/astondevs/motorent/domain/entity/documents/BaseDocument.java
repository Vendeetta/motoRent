package ru.astondevs.motorent.domain.entity.documents;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@MappedSuperclass
public class BaseDocument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //TODO Переделать через конвертер на код документа
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
