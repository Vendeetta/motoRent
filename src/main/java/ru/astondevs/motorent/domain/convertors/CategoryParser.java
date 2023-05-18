package ru.astondevs.motorent.domain.convertors;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import ru.astondevs.motorent.domain.entity.CategoryDriversLicence;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Converter
public class CategoryParser implements AttributeConverter<List<CategoryDriversLicence>, String> {
    @Override
    public String convertToDatabaseColumn(List<CategoryDriversLicence> attribute) {
        return attribute.stream()
                .map(Enum::toString)
                .collect(Collectors.joining());
    }

    @Override
    public List<CategoryDriversLicence> convertToEntityAttribute(String dbData) {
        return Arrays.stream(dbData.split(""))
                .map(CategoryDriversLicence::valueOf)
                .collect(Collectors.toList());
    }
}
