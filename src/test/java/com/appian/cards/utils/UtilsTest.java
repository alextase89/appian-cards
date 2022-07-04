package com.appian.cards.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.appian.cards.model.Card;
import com.appian.cards.model.FaceValueEnum;
import com.appian.cards.model.SuiteTypeEnum;
import java.util.List;
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
    void givenPositiveNumberOrZeroAsString_whenIsNumericAndNonNegative_thenReturnTrue() {
        assertTrue(Utils.isNumericAndNonNegative("0"));
        assertTrue(Utils.isNumericAndNonNegative("5"));
        assertTrue(Utils.isNumericAndNonNegative("8"));
    }

    @Test
    void givenNonPositiveNumberOrZeroAsString_whenIsNumericAndNonNegative_thenReturnFalse() {
        assertFalse(Utils.isNumericAndNonNegative("-1"));
        assertFalse(Utils.isNumericAndNonNegative("-5"));
        assertFalse(Utils.isNumericAndNonNegative("One"));
    }

    @Test
    void givenCardList_whenPrintableCardList_thenResultedStringHasSameSizeSeparatedByPipe() {
        var cardList = List.of(
            new Card(SuiteTypeEnum.CLUBS, FaceValueEnum.ACE),
            new Card(SuiteTypeEnum.DIAMONDS, FaceValueEnum.FIVE),
            new Card(SuiteTypeEnum.HEARTS, FaceValueEnum.FOUR),
            new Card(SuiteTypeEnum.DIAMONDS, FaceValueEnum.NINE),
            new Card(SuiteTypeEnum.SPADES, FaceValueEnum.SEVEN)
        );

        String printable = Utils.printableCardList(cardList);

        assertNotNull(printable);
        assertEquals(cardList.size(), printable.split("\\|").length);
    }
}
