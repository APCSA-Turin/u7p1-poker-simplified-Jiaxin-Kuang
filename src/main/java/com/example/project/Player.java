package com.example.project;
import java.util.ArrayList;
import java.util.Arrays;

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
        System.out.println(allCards);
        String suitString = "", rankingString = "";
        for(int i = 0; i < 4; i ++){
            suitString += findSuitFrequency().get(i);
        }
        for(int i = 0; i < 13; i ++){
            rankingString += findRankingFrequency().get(i);
        }
        if(rankingString.substring(8).equals("11111") && suitString.contains("5")){
            return "Royal Flush";
        }
        else if(rankingString.contains("11111") && suitString.contains("5")){
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
        else if(rankingString.contains("11111")){
            return "Straight";
        }
        else if(rankingString.contains("3")){
            return "Three of a Kind";
        }
        //Two Pair
        else if(rankingString.contains("2")){
            return "A Pair";
        }
        else if(rankingString.substring(13).equals("A")){
            return "High Card";
        }
        else{
            return "Nothing";
        }
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

    public ArrayList<Integer> findRankingFrequency(){
        int two = 0, three = 0, four = 0, five = 0, six = 0, seven = 0, eight = 0, nine = 0, ten = 0, j = 0, q = 0, k = 0, a = 0;
        for(int i = 0; i < allCards.size(); i ++){
            String currentSuit = allCards.get(i).getRank();
            if(currentSuit.equals("2")){
                two ++;
            }
            else if(currentSuit.equals("3")){
                three ++;
            }
            else if(currentSuit.equals("4")){
                four ++;
            }
            else if(currentSuit.equals("5")){
                five ++;
            }
            else if(currentSuit.equals("6")){
                six ++;
            }            
            else if(currentSuit.equals("7")){
                seven ++;
            }
            else if(currentSuit.equals("8")){
                eight ++;
            }
            else if(currentSuit.equals("9")){
                nine ++;
            }
            else if(currentSuit.equals("10")){
                ten ++;
            }
            else if(currentSuit.equals("J")){
                j ++;
            }
            else if(currentSuit.equals("Q")){
                q ++;
            }
            else if(currentSuit.equals("K")){
                k ++;
            }
            else{
                a ++;
            }
        }
        ArrayList<Integer> rankingFrequency = new ArrayList<>(Arrays.asList(two, three, four, five, six, seven, eight, nine, ten, j, q, k, a));
        return rankingFrequency; 
    }

    public ArrayList<Integer> findSuitFrequency(){
        int club = 0, heart = 0, diamond = 0, spade = 0;
        for(int i = 0; i < allCards.size(); i ++){
            String currentSuit = allCards.get(i).getSuit();
            if(currentSuit.equals("♠")){
                club ++;
            }
            else if(currentSuit.equals("♥")){
                heart ++;
            }
            else if(currentSuit.equals("♣")){
                diamond ++;
            }
            else{
                spade ++;
            }   
        }
        ArrayList<Integer> suitFrequency = new ArrayList<>(Arrays.asList(club, heart, diamond, spade));
        return suitFrequency; 
    }
   
    @Override
    public String toString(){
        return hand.toString();
    }
}
