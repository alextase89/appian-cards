package com.appian.cards.service;

import static com.appian.cards.utils.Utils.getRandomInt;

import com.appian.cards.model.Card;
import com.appian.cards.model.FaceValueEnum;
import com.appian.cards.model.SuiteTypeEnum;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Queue;
import java.util.Set;

public class DeckServiceImpl implements DeckService {

    private final Queue<Card> cardDeck;

    public DeckServiceImpl() {
        this.cardDeck = new ArrayDeque<>();
    }

    @Override
    public void newCardDeck() {
        this.cardDeck.clear();
        this.cardDeck.addAll(this.fillDeck());
        this.shuffle();
    }

    @Override
    public void shuffle() {
        var currentDeck = new ArrayList<>(this.cardDeck);
        this.cardDeck.clear();
        while(!currentDeck.isEmpty()) {
            int randomDeckPosition = getRandomInt(currentDeck.size());
            this.cardDeck.add(currentDeck.remove(randomDeckPosition));
        }
    }

    @Override
    public Optional<Card> dealOneCard() {
        return Optional.ofNullable(this.cardDeck.poll());
    }

    @Override
    public List<Card> dealNCard(int cardAmount) {
        var dealtCards = new ArrayList<Card>();
        for (int i = 0; i < cardAmount; i++) {
            this.dealOneCard().ifPresent(dealtCards::add);
        }
        return dealtCards;
    }

    @Override
    public List<Card> cardDeck() {
        return List.copyOf(this.cardDeck);
    }

    @Override
    public boolean isCardDeckEmpty() {
        return this.cardDeck.isEmpty();
    }

    private Set<Card> fillDeck() {
        var newDeck = new HashSet<Card>();
        for (SuiteTypeEnum suiteType: SuiteTypeEnum.values()) {
            for(FaceValueEnum value: FaceValueEnum.values()) {
                newDeck.add(new Card(suiteType, value));
            }
        }
        return newDeck;
    }
}
