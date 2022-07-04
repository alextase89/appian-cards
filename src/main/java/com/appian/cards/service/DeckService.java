package com.appian.cards.service;

import com.appian.cards.model.Card;
import java.util.List;
import java.util.Optional;

public interface DeckService {

    void newCardDeck();

    void shuffle();

    Optional<Card> dealOneCard();

    List<Card> dealNCard(int cardAmount);

    List<Card> cardDeck();

    boolean isCardDeckEmpty();
}
