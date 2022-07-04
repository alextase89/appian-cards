package com.appian.cards.model;

public enum SuiteTypeEnum {

    HEARTS('\u2665'),
    SPADES('\u2660'),
    CLUBS('\u2663'),
    DIAMONDS('\u2666');

    private final char unicodeValue;

    SuiteTypeEnum(char unicodeValue) {
        this.unicodeValue = unicodeValue;
    }

    public char getUnicodeValue() {
        return unicodeValue;
    }
}
