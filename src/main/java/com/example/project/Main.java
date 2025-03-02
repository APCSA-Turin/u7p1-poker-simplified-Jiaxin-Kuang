package com.example.project;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffleDeck();
        System.out.println(deck.getCards());
        deck.drawCard();
        System.out.println(deck.getCards());
    }
}
