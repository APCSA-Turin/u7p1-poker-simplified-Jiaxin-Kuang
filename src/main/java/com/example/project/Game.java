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
            int p1Rating = 0, p2Rating = 0;
            if(p1HandValue == 8 || p1HandValue == 5){
                p1Rating = p1.highestOccurence(3);
                p2Rating = p2.highestOccurence(3);
                System.out.println(p1Rating + " " + p2Rating);
                if(p1Rating > p2Rating){
                    return "Player 1 wins!";
                }
                else if(p1Rating < p2Rating){
                    return "Player 2 wins!";
                }
            }
            if(p1HandValue == 8 || p1HandValue == 4 || p1HandValue == 3){
                p1Rating = p1.highestOccurence(2);
                p2Rating = p2.highestOccurence(2);
                System.out.println(p1Rating + " " + p2Rating);
                if(p1Rating > p2Rating){
                    return "Player 1 wins!";
                }
                else if(p1Rating < p2Rating){
                    return "Player 2 wins!";
                }
            }
            p1Rating = p1.highestOccurenceHand(1);
            p2Rating = p2.highestOccurenceHand(1);
            System.out.println(p1Rating + " " + p2Rating);
            if(p1Rating > p2Rating){
                return "Player 1 wins!";
            }
            else if(p1Rating < p2Rating){
                return "Player 2 wins!";
            }
            else{
                return "Tie!";
            }
        }
    }

    public static void play(){ //simulate card playing
    }  

}