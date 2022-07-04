package com.appian.cards.app;

import static com.appian.cards.utils.Utils.isNumericAndGreaterThanZero;
import static com.appian.cards.utils.Utils.isNumericAndNonNegative;
import static com.appian.cards.utils.Utils.printLine;
import static com.appian.cards.utils.Utils.printEmptyLine;
import static com.appian.cards.utils.Utils.printableCardList;

import com.appian.cards.model.Card;
import com.appian.cards.service.DeckService;
import java.util.Scanner;

public class App {

    private final Scanner scanner;
    private final DeckService deckService;

    public App(DeckService deckService) {
        this.scanner = new Scanner(System.in);
        this.deckService = deckService;
    }

    public void init() {
        this.printOptions();
    }

    private void printOptions() {
        printEmptyLine();
        printLine("*=============== Appian Deck Card Test ===============*");
        printLine("* Please select an option:                            *");
        printLine("* (1) New Deck                                        *");
        printLine("* (2) Shuffle                                         *");
        printLine("* (3) Deal One Card                                   *");
        printLine("* (4) Deal N cards                                    *");
        printLine("* (5) Reveal cards                                    *");
        printLine("* (0) Bye Bye                                         *");
        printLine("*=====================================================*");

        handleInputOption();
    }

    private void handleInputOption() {
        String inputValue = this.scanner.next();
        if (isValidInputOption(inputValue)) {
            switch (Integer.parseInt(inputValue)) {
                case 1:
                    this.newCardDeck();
                    break;
                case 2:
                    this.shuffle();
                    break;
                case 3:
                    this.dealOneCard();
                    break;
                case 4:
                    this.dealNCards();
                    break;
                case 5:
                    this.revealCards();
                    break;
                default:
                    System.exit(0);
            }
        } else {
            printLine("Please enter a valid option! (0-5)");
        }

        printOptions();
    }

    private void newCardDeck() {
        this.deckService.newCardDeck();
        printLine("A new card deck is created and shuffled!");
    }

    private void shuffle() {
        if (this.deckService.isCardDeckEmpty()) {
            this.printEmptyDeckCardMessage();
        } else {
            this.deckService.shuffle();
            printLine("Current card deck was shuffled!");
        }
    }

    private void dealOneCard() {
        var cardOptional = this.deckService.dealOneCard();
        cardOptional.ifPresentOrElse(this::printDealtCardMessage, this::printEmptyDeckCardMessage);
    }

    private void dealNCards() {
        if (this.deckService.isCardDeckEmpty()) {
            this.printEmptyDeckCardMessage();
        } else {
            printLine("Please enter the number of cards:");
            String inputValue = this.scanner.next();

            if (isNumericAndGreaterThanZero(inputValue)) {
                int amountRequested = Integer.parseInt(inputValue);
                var dealtCards = this.deckService.dealNCard(amountRequested);
                String printableCards = printableCardList(dealtCards);
                printLine(String.format("%d cards dealt from %d requested.", dealtCards.size(), amountRequested));
                printLine("cards: " + printableCards);
            } else {
                printLine("Please enter a valid greater than zero number!");
                this.dealNCards();
            }
        }
    }

    private void revealCards() {
        if (this.deckService.isCardDeckEmpty()) {
            this.printEmptyDeckCardMessage();
        } else {
            var deck = this.deckService.cardDeck();
            String printableCards = printableCardList(deck);
            printLine(String.format("deck size: %d cards", deck.size()));
            printLine("cards: " + printableCards);
        }
    }

    private boolean isValidInputOption(String value) {
        return isNumericAndNonNegative(value) && Integer.parseInt(value) < 6;
    }

    private void printDealtCardMessage(Card card) {
        printLine(
            String.format("You deal %s (%s of %s)", card.graphicValue(), card.getValue(), card.getSuiteType())
        );
    }

    private void printEmptyDeckCardMessage() {
        printLine("No cards left on deck, please ask for a new one! [Option 1]");
    }
}
