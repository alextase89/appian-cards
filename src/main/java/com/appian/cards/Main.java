package com.appian.cards;

import com.appian.cards.app.App;
import com.appian.cards.service.DeckServiceImpl;

public class Main {

    public static void main( String[] args ) {
        var app = new App(new DeckServiceImpl());
        app.init();
    }
}
