package ru.astondevs.motorent.domain.entity.documents;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.astondevs.motorent.domain.convertors.CategoryParser;
import ru.astondevs.motorent.domain.entity.BaseDocument;
import ru.astondevs.motorent.domain.entity.CategoryDriversLicence;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "driver_licence")
public class DriverLicence extends BaseDocument {
    @Column(name = "categories")
    @Convert(converter = CategoryParser.class)
    private final List<CategoryDriversLicence> categories = new ArrayList<>();
    @Column(name = "validation_on_gibdd", columnDefinition = "BIT")
    private Boolean validationOnGIBDD = false;
    @Column(name = "special_marks")
    private String specialMarks;
}
