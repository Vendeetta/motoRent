package ru.astondevs.motorent.domain.convertors;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import ru.astondevs.motorent.domain.entity.Category;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Converter
public class CategoryParser implements AttributeConverter<List<Category>, String> {
    @Override
    public String convertToDatabaseColumn(List<Category> attribute) {
        //TODO проверки на null
        return attribute.stream()
                .map(Enum::toString)
                .collect(Collectors.joining());
    }

    @Override
    public List<Category> convertToEntityAttribute(String dbData) {
        return Arrays.stream(dbData.split(""))
                .map(Category::valueOf)
                .collect(Collectors.toList());
    }
}
