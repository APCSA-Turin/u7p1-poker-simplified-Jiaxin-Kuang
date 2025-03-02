package com.example.project;
import java.util.ArrayList;

public class Player{
    private ArrayList<Card> hand;
    private ArrayList<Card> allCards; //the current community cards + hand
    String[] suits  = Utility.getSuits();
    String[] ranks = Utility.getRanks();
    
    public Player(){
        hand = new ArrayList<>();
        allCards = new ArrayList<>();
    }

    public ArrayList<Card> getHand(){return hand;}
    public ArrayList<Card> getAllCards(){return allCards;}

    public void addCard(Card c){
        hand.add(c);
    }

    public String playHand(ArrayList<Card> communityCards){ 
        allCards = new ArrayList<>();
        allCards.add(hand.get(0));
        allCards.add(hand.get(1));
        for(Card card : communityCards){
            allCards.add(card);
        }
        String suitString = "", rankingString = "", rankingString2 = "";
        int pairCount = 0;
        ArrayList<Integer> rankFrequency = findRankingFrequency();
        ArrayList<Integer> suitFreqency = findSuitFrequency();
        for(int i = 0; i < 4; i ++){
            suitString += suitFreqency.get(i);
        }
        for(int i = 0; i < 13; i ++){
            rankingString += rankFrequency.get(i);
            if(rankFrequency.get(i) == 2){
                pairCount ++;
            }
        }
        rankingString2 = rankingString.substring(4) + rankingString.substring(0, 4); 
        if(rankingString.substring(8).equals("11111") && suitString.contains("5")){
            return "Royal Flush";
        }
        else if((rankingString.contains("11111") || rankingString2.contains("11111")) && suitString.contains("5")){
            return "Straight Flush";
        }
        else if(rankingString.contains("4")){
            return "Four of a Kind";
        }
        else if(rankingString.contains("3") && rankingString.contains("2")){
            return "Full House";
        }
        else if(suitString.contains("5")){
            return "Flush";
        }
        else if(rankingString.contains("11111") || rankingString2.contains("11111")){
            return "Straight";
        }
        else if(rankingString.contains("3")){
            return "Three of a Kind";
        }
        else if(pairCount == 2){
            return "Two Pair";
        }
        else if(pairCount == 1){
            return "A Pair";
        }
        else if(hand.toString().contains("A")){
            return "High Card";
        }
        else{
            return "Nothing";
        }
    }

    public int highestOccurence(int cardAmount){
        ArrayList<Integer> rankFrequency = findRankingFrequency();
        for(int i = 12; i >= 0; i --){
            if(rankFrequency.get(i) == cardAmount){
                return i;
            }
        }
        return -1;
    }

    public int highestOccurenceHand(int cardAmount){
        ArrayList<Integer> rankFrequencyHand = findRankingFrequencyHand();
        for(int i = 12; i >= 0; i --){
            if(rankFrequencyHand.get(i) == cardAmount){
                return i;
            }
        }
        return -1;
    }

    public void sortAllCards(){
        for(int i = 1; i < hand.size(); i ++){
            String currentCard = hand.get(i).getRank();
            int j = i - 1;
            while(j >= 0 && currentCard.compareTo(hand.get(j).getRank()) < 0){
                hand.set(j + 1, hand.get(j));
                j --;
            }
            hand.set(j + 1, hand.get(i));
        }
    } 

    public ArrayList<Integer> findRankingFrequencyHand(){
        int[] holderArray = new int[13];
        for(Card card : hand){
            int cardRanking = Utility.getRankValue(card.getRank()) - 2;
            holderArray[cardRanking] ++;
        }   
        ArrayList<Integer> rankingFrequencyHand = new ArrayList<>();
        for(int num : holderArray){
            rankingFrequencyHand.add(num);
        }
        return rankingFrequencyHand;
    }

    public ArrayList<Integer> findRankingFrequency(){
        int[] holderArray = new int[13];
        for(Card card : allCards){
            int cardRanking = Utility.getRankValue(card.getRank()) - 2;
            holderArray[cardRanking] ++;
        }   
        ArrayList<Integer> rankingFrequency = new ArrayList<>();
        for(int num : holderArray){
            rankingFrequency.add(num);
        }
        return rankingFrequency;
    }

    public ArrayList<Integer> findSuitFrequency(){
        int[] holderArray = new int[4];
        for(Card card : allCards){
            int cardSuit = Utility.getSuitValue(card.getSuit());
            holderArray[cardSuit] ++;
        } 
        ArrayList<Integer> suitFrequency = new ArrayList<>();
        for(int num : holderArray){
            suitFrequency.add(num);
        }
        return suitFrequency;
    }
   
    @Override
    public String toString(){
        return hand.toString();
    }
}
