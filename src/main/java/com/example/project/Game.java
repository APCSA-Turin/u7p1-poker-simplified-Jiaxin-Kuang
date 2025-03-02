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
        if(p1HandValue > p2HandValue){
            return "Player 1 wins!";
        }
        else if(p2HandValue > p1HandValue){
            return "Player 2 wins!";
        }
        else{
            String result = "";
            if(p1HandValue == 8 || p1HandValue == 5){
                result = compareRatings(p1, p2, 3, "allCards");
                if(!result.equals("Tie!")){
                    return result;
                }
            } 
            if(p1HandValue == 8 || p1HandValue == 4 || p1HandValue == 3){
                result = compareRatings(p1, p2, 2, "allCards");
                if(!result.equals("Tie!")){
                return result;
                }
            } 
            result = compareRatings(p1, p2, 1, "handOnly");
            return result;
        }
    }

    public static void play(){ //simulate card playing
    }  
}