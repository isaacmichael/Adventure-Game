package edu.bsu.cs222.PirateAdventure;

public class GameLost {
    static boolean gameLost = false;
    public static void loseGame(){
        System.out.println("you lose");
        RandomEvents.canMove = false;
        gameLost = true;
        RandomEvents.currentEvent = "YOU LOSE! PLEASE CLOSE AND REOPEN TO TRY AGAIN";
    }
}
