package com.appian.cards.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DeckServiceTest {

    private DeckService deckService;

    @BeforeEach
    public void setUp() {
        this.deckService = new DeckServiceImpl();
    }

    @Test
    void whenNewCardDeck_thenCardDeckSizeIs52() {
        this.deckService.newCardDeck();

        var cardDeck = this.deckService.cardDeck();
        assertFalse(cardDeck.isEmpty());
        assertEquals(52, cardDeck.size());
    }

    @Test
    void givenNewCardDeck_whenDealOneCard_thenDeckSizeDecrease1Card() {
        this.deckService.newCardDeck();

        this.deckService.dealOneCard();
        assertEquals(51, this.deckService.cardDeck().size());

        this.deckService.dealOneCard();
        assertEquals(50, this.deckService.cardDeck().size());
    }

    @Test
    void givenEmptyCardDeck_whenDealOneCard_thenOptionalCardIsNotPresent() {
        this.deckService.newCardDeck();

        this.deckService.dealNCard(52);
        assertTrue(this.deckService.isCardDeckEmpty());

        var optionalCard = this.deckService.dealOneCard();
        assertFalse(optionalCard.isPresent());
    }

    @Test
    void givenNewCardDeck_whenDealNCards_thenDeckCardSizeDecreaseNCards() {
        this.deckService.newCardDeck();

        var dealtCards = this.deckService.dealNCard(5);
        var deck = this.deckService.cardDeck();

        assertEquals(5, dealtCards.size());
        assertEquals(47, deck.size());
    }

    @Test
    void givenCardDeckWith5Cards_whenDeal7Cards_thenDealtCardsSizeIs5AndCardDeckIsEmpty() {
        this.deckService.newCardDeck();

        this.deckService.dealNCard(47);
        var deck = this.deckService.cardDeck();
        assertEquals(5, deck.size());

        var dealtCards = this.deckService.dealNCard(7);

        assertEquals(5, dealtCards.size());
        assertTrue(this.deckService.isCardDeckEmpty());
    }

    @Test
    void givenCardDeck_whenShuffle_thenCardDeckHasSameSizeButDifferentOrder() {
        this.deckService.newCardDeck();

        var initialCardDeck = this.deckService.cardDeck();
        assertEquals(initialCardDeck, this.deckService.cardDeck());

        this.deckService.shuffle();
        var currentCardDeck = this.deckService.cardDeck();

        assertEquals(initialCardDeck.size(), currentCardDeck.size());
        assertNotEquals(initialCardDeck, currentCardDeck);
    }

}
