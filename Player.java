/**INEW-2338-001/COSC 2336-001--Jennifer Ayala--10/14/2019--Mid-Term-Project
 * Create an app to allow users to create a txt file to store data values
 * associated with Player objects
 * This file defines the methods required for the application --PlayerDAO.java 
*/

package business;

import db.PlayerDAO; // access the PlayerDAO interface
import java.text.NumberFormat; // access to Number format class for currency format

/**
 * The <code>Player</code> class implements the DAO interface & define the player
 * object, contains instance variables, constructor, set & get methods
 * @author Jennifer Ayala
 * @version 1.0.0
*/
public class Player {
    /** Step #10 - create 3 instance variables: player's name, amount of money
     player has on table, player's password*/
    private String playerName;
    private double money;
    private String password;
    
    /**Step 11 - Create 2 Constructors  */
    /** 1st Constructor - Creates a Player with no parameters 
     */
    public Player(){
     }
    
    //2nd Constructor - Name, password, & amount of money:
    public Player(String playerName, double money, String password){
        this.playerName = playerName;
        this.money = money;
        this.password = password;
    }
    
    /**Step 10 - Create getter & setter methods for all instance variables
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
     * @param money <code>double</code> double variable
     */
    public void setMoney(double money){
        this.money = money;
    }
    
    /** 
     * Gets the money variable 
     * @return money <code>double</code> for the player object
     */
    public double getMoney(){
        return money;
    }
    
    /**
     * Sets the password
     * @param password <code>String</code> string variable
     */
    public void setPassword(String password){
        this.password = password;
    }
    
    /**
     * Gets the password variable
     * @return password <code>password</code> for the player object
     */
    public String getPassword(){
        return password;
    }
     /**
     * Formats money variable into currency 
     * @return money <code>money</code> in currency format
     */
    public String getMoneyFormatted(){
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(money);
    }
    
}
