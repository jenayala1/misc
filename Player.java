/**INEW-2338-001/COSC 2336-001--Jennifer Ayala--11/10/2019--Programming Project Quiz 2
 * Create an app to allow users to enter a guess and wage after selecting a player
 * for a random number selection game, update balance thru a GUI and write
 * results to a file
 * This file defines the player object -- Player.java 
*/

package business;

import db.PlayerDAO; // access the PlayerDAO interface
import java.lang.Object; //access to the object class
import java.text.NumberFormat; // access to Number format class for currency format

/**
 * The <code>Player</code> class implements the DAO interface & define the player
 * object, contains instance variables, constructor, set & get methods
 * @author Jennifer Ayala
 * @version 1.0.0
*/
public class Player {
    /** Create 2 instance variables: player's name, amount of money
     player has on table*/
    private String playerName;
    private double balance;
  
    
    /** 1st Constructor - Creates a Player with no parameters */
    public Player(){
     }
    
    /**2nd Constructor - Name & amount of balance: */
    public Player(String playerName, double balance){
        this.playerName = playerName;
        this.balance = balance;
    }
    
    /** 
     * Create getter & setter methods for all instance variables
     * Sets the playerName
     * @param playerName <code>String</code> string variable
     */
    public void setPlayerName(String playerName){
        this.playerName = playerName;
    }
    
    /** 
     * Gets the playerName
     * @return playerName <code>String</code> for the player object
    */
    public String getPlayerName(){
        return playerName;
    }
    
    /** 
     * Sets the money variable 
     * @param balance <code>double</code> double variable
     */
    public void setBalance(double balance){
        this.balance = balance;
    }
    
    /** 
     * Gets the balance variable 
     * @return balance <code>double</code> for the player object
     */
    public double getBalance(){
        return balance;
    }
    
   /**
     * Formats balance variable into currency 
     * @return balance <code>money</code> in currency format
     */
    public String getMoneyFormatted(){
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(balance);
    }
    
}