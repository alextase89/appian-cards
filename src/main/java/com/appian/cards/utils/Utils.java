package com.appian.cards.utils;

import com.appian.cards.model.Card;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class Utils {

    private static final Random RANDOM_INSTANCE = new Random();

    private Utils() {}

    public static int getRandomInt(int bound) {
        return RANDOM_INSTANCE.nextInt(bound);
    }

    public static boolean isNumericAndNonNegative(String strNum) {
        try {
            return Integer.parseInt(strNum) >= 0;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    public static boolean isNumericAndGreaterThanZero(String strNum) {
        return isNumericAndNonNegative(strNum) && Integer.parseInt(strNum) > 0;
    }

    public static String printableCardList(List<Card> cardList) {
        return cardList.stream()
            .map(Card::graphicValue)
            .collect(Collectors.joining("|"));
    }

    public static void printLine(String msg) {
        System.out.println(msg);
    }

    public static void printEmptyLine() {
        System.out.println();
    }
}
