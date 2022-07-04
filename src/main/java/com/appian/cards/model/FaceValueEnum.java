package com.appian.cards.model;

public enum FaceValueEnum {

    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    TEN("10"),
    JACK("J"),
    QUEEN("Q"),
    KING("K"),
    ACE("A");
    private final String value;

    FaceValueEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
