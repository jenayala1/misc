/**INEW-2338-001/COSC 2336-001--Jennifer Ayala--11/10/2019--Programming Project Quiz 2
 *Create an app to allow users to enter a guess and wage after selecting a player
 * for a random number selection game, update balance thru a GUI and write
 * results to a file
 * This file defines I/O methods -- PlayerDAO.java 
*/
package db;

import java.util.List; // access the List interface
import business.Player; //import statement to access Player object class

/**
 * The <code>PlayerDAO</code> interface defines the I/O methods & constants for a  
 * data access object
 * get() method returns a single player object by player name
 * getAll() method returns a List object that contains all Player objects
 * update() method to write the player data to file, using a 
 * boolean indicating success of operation
 * @author Jennifer Ayala
 * @version 1.0.0
*/
public interface PlayerDAO {
    Player get(String playerName); 
    List<Player> getAll();  
    boolean update(Player p);
}