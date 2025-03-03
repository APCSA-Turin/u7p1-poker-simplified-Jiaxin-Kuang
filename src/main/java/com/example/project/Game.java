package com.example.project;
import java.util.ArrayList;

public class Game{
    private static String compareRatings(Player p1, Player p2, int occurence, String type){
        int p1Rating = 0, p2Rating = 0;
        if(type.equals("allCards")){
            p1Rating = p1.highestOccurence(occurence);
            p2Rating = p2.highestOccurence(occurence);
        }
        else{
            p1Rating = p1.highestOccurenceHand(occurence);
            p2Rating = p2.highestOccurenceHand(occurence);
        }
        if(p1Rating > p2Rating){
            return "Player 1 wins!";
        }
        else if(p1Rating < p2Rating){
            return "Player 2 wins!";
        }
        return "Tie!";
    }
    
    public static String determineWinner(Player p1, Player p2, String p1Hand, String p2Hand, ArrayList<Card> communityCards){
        int p1HandValue = Utility.getHandRanking(p1Hand); 
        int p2HandValue = Utility.getHandRanking(p2Hand);
        if(p1HandValue > p2HandValue){ //If player 1's one hand is higher than player 2's, player 1 wins
            return "Player 1 wins!";
        }
        else if(p2HandValue > p1HandValue){ //If player 2's one hand is higher than player 1's, player 2 wins
            return "Player 2 wins!";
        }
        else{ //Runs if player 2 and player 1 have same type of hand
            String result = ""; 
            if(p1HandValue == 8 || p1HandValue == 5){ //If the players' hands are full houses or three of a kind, method checks which three cards are higher
                result = compareRatings(p1, p2, 3, "allCards");
                if(!result.equals("Tie!")){
                    return result;
                } //If tie, method continues to the if statement
            } 
            if(p1HandValue == 8 || p1HandValue == 4 || p1HandValue == 3){ //If the players' hands are full houses, three of a kind, or two pairs, method checks which two cards are higher
                result = compareRatings(p1, p2, 2, "allCards");
                if(!result.equals("Tie!")){
                return result;
                } //If tie, method continues to the if statement
            } 
            result = compareRatings(p1, p2, 1, "handOnly"); //Checks players' cards to see which has the higher card in their hand to determine winner 
            return result; //If no one has a higher card, game ends in tie
        }
    }

    public static void play(){ //simulate card playing
    }  
}