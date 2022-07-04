package com.appian.cards.utils;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class UtilsTest {

    @Test
    void givenIntBound_whenGetRandomInt_thenReturnedIntIsLowerThanBound() {
        int bound = 50;
        int randomInt = Utils.getRandomInt(bound);
        assertTrue(randomInt > 0);
        assertTrue(randomInt < bound);
    }

    @Test
    void givenPositiveNumberOrZeroAsString_whenIsNumericAndNonNegative_thenTrue() {
        assertTrue(Utils.isNumericAndNonNegative("0"));
        assertTrue(Utils.isNumericAndNonNegative("5"));
        assertTrue(Utils.isNumericAndNonNegative("8"));
    }

    @Test
    void givenNonPositiveNumberOrZeroAsString_whenIsNumericAndNonNegative_thenFalse() {
        assertFalse(Utils.isNumericAndNonNegative("-1"));
        assertFalse(Utils.isNumericAndNonNegative("-5"));
        assertFalse(Utils.isNumericAndNonNegative("One"));
    }
}
