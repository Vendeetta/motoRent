package ru.astondevs.motorent.domain.entity.rent.vehicle;

public enum TypeEngine {
    PETROL("Бензиновый"),
    DIESEL("Дизельный");

    private final String value;

    TypeEngine(String value) {
        this.value = value;
    }
}
