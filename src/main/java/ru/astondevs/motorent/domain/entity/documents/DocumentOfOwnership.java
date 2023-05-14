package ru.astondevs.motorent.domain.entity.documents;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "document_of_ownership")
public class DocumentOfOwnership extends BaseDocument {
}
