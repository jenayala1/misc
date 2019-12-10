/**INEW-2338-001/COSC 2336-001--Jennifer Ayala--9/16/2019--Project Quiz 1
 * Build an app to enable users to add players, place wagers & 3 number guesses
* This class defines user variables --Player.java */

package casinoapp;

import java.util.Arrays; //access the array class

//Step #11 - create the Player class with four instance variables
public class Player {
    private String playerName; //player's name
    private double pAmount; //amount of money player has
    private int [] guesses; // array to capture number of guesses per player
    private double wager; //amount of money player wages
    
    public Player(){ //Step 13 - constructor without parameters
    //creating an instance of the variables set to default values
        playerName = ""; //blank string
        pAmount = 0; // 0 dollar amount
        guesses = new int[] {0,0,0}; //empty array of 3 elements
        wager = 0; // 0 wager default
        
    }
    //Step 13 - create constructor with name & amount as parameters
    public Player(String playerName, double pAmount){
        this.playerName = playerName;
        this.pAmount = pAmount;
    }
     //Step 12 - Create get & setter methods for the instance variables
    public void setName(String playerName){
        this.playerName = playerName;
    }
    
    public String getPlayerName(){
        return playerName;
    }
    
    public void setAmount(double pAmount){
        this.pAmount = pAmount;
    }
    
    public double getAmount(){
        return pAmount;
    }
    
    public void setGuesses(int[] guesses){
        this.guesses = guesses;
    }
    
    public int[] getGuesses(){
        return guesses;
    }
    
    public void setWager(double wager){
        this.wager = wager;
    }
    
    public double getWager(){
        return wager;
    }
    
}
