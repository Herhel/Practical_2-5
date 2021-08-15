package com.alfa.work2;

public class Runner {
    private Card[] cardDeck;

    public void run() {
        cardDeck = new Card[Suit.values().length * Rank.values().length];
        createFullCardDeck();
        System.out.println("Колода карт:");
        printCardDeck(cardDeck);
    }

    private void createFullCardDeck() {
        int i = 0;
        for (Rank rank : Rank.values()) {
            for (Suit suit : Suit.values()) {
                cardDeck[i] = new Card(suit, rank);
                i++;
            }
        }
    }

    public void printCardDeck(Card[] cards) {
        for (Card card : cards) {
            System.out.println(card);
        }
    }
}
