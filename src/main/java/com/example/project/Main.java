package com.example.project;

public class Main {
    public static void main(String[] args) {
        Player player = new Player();
        Card card = new Card("A", "♠");
        player.addCard(card);
        System.out.println(player.getHand().size());
        System.out.println(player.getHand().get(0).toString());
    }
}
