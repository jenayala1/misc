/**INEW-2338-001/COSC 2336-001--Jennifer Ayala--10/14/2019--Mid-Term-Project
 * Create an app to allow users to create a txt file to store data values
 * associated with Player objects
*/
package db; 

import java.util.List; // access the List interface
import business.Player; //import statement to access Player object class

/**
 * The <code>PlayerDAO</code> interface defines the I/O methods & constants for a  
 * data access object
 * get() method returns a single player object by player name
 * getAll() method returns a List object that contains all Player objects
 * add(), update(), delete() methods to write the player data to file, using a 
 * boolean indicating success of operation
 * @author Jennifer Ayala
 * @version 1.0.0
*/
public interface PlayerDAO {
    Player get(String playerName); 
    List<Player> getAll();  
    boolean add(Player p);
    boolean update(Player p);
    boolean delete(Player p);
}
