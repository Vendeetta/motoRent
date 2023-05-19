package ru.astondevs.motorent.domain.entity.documents;

public enum TypeDocument {
    PASSPORT(21,"Паспорт РФ"),
    DRIVER_LICENCE(1, "Водительское удостоверение"),
    PASSPORT_OF_A_FOREIGN_CITIZEN(10, "Паспорт иностранного гражданина"),
    RESIDENCE(2, "Вид на жительство"),
    TEMPORARY_RESIDENCE_PERMIT(15, "РВП"),
    CNILS(3, "СНИЛС"),
    CERTIFICATE_D_IMMATRICULATION(4, "Свидетельство о регистрации ТС"),
    INSURANCE_POLICE(5, "Страховой полис"),
    LEASE_CONTRACT(6, "Договор аренды"),
    VOUCHER(7, "Расписка"),
    PTS(8, "Паспорт транспортного средства"),
    APPROVAL_TC(9, "Одобрение типа ТС")
    ;

    private final Integer code;
    private final String value;

    TypeDocument(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public Integer getCode() {
        return code;
    }
}
