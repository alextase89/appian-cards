package com.appian.cards.model;

public class Card {

    private final SuiteTypeEnum suiteType;
    private final FaceValueEnum value;

    public Card(SuiteTypeEnum suiteType, FaceValueEnum value) {
        this.suiteType = suiteType;
        this.value = value;
    }

    public SuiteTypeEnum getSuiteType() {
        return suiteType;
    }

    public FaceValueEnum getValue() {
        return value;
    }

    public String graphicValue() {
        return String.format("%s%s", value.getValue(), suiteType.getUnicodeValue());
    }
}
