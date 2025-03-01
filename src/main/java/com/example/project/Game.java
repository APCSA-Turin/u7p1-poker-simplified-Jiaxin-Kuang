package com.example.project;
import java.util.ArrayList;


public class Game{
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
            return "Tie!";
        }
    }

    public static void play(){ //simulate card playing
    
    }
        
}