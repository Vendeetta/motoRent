package ru.astondevs.motorent.domain.entity.documents;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import ru.astondevs.exceptions.ArrayIsEmptyOrNull;
import ru.astondevs.motorent.domain.convertors.CategoryParser;
import ru.astondevs.motorent.domain.entity.Category;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@Entity(name = "driver_licence")
public class DriverLicence extends BaseDocument {
    @Column(name = "categories")
    @Convert(converter = CategoryParser.class)
    private final List<Category> categories = new ArrayList<>();
    @Column(name = "validation_on_gibdd", columnDefinition = "BIT")
    private Boolean validationOnGIBDD = false;
    @Column(name = "special_marks")
    private String specialMarks;

    public void setCategories(List<Category> categories) {
        this.categories.addAll(categories);
    }

    public void addCategories(String... category) {
        if (category != null && category.length != 0) {
            Arrays.stream(category).map(s -> Category.valueOf(s.toUpperCase())).forEach(categories::add);
        } else {
            throw new ArrayIsEmptyOrNull("Not valid input array" + this.getClass().getName());
        }
    }
}
