/**INEW-2338-001/COSC 2336-001--Jennifer Ayala--10/14/2019--Mid-Term-Project
 * Create an app to allow users to create a txt file to store data values
 * associated with Player objects
*/
package db;

/**
 * The <code>PlayerTextFile</code> class provides methods to read and write players
 * to a text file
 * @author Jennifer Ayala
 * @version 1.0.0
*/

import java.io.*;       //access to the IO exception class
import java.nio.file.*; //package to work with directories & files
import java.util.*;     

import business.Player;    //access the Player object class

public class PlayerTextFile implements PlayerDAO {
    /**
     * Define & initialize instance variables
    */
    private List<Player> players = null;  //
    private Path playersPath = null;
    private File playersFile = null;
    private final String FIELD_SEP = "\t";  // delimiter
    
    /**
     * Constructor
     */
    public PlayerTextFile(){
        playersPath = Paths.get("players.txt"); //create path object for players file
        playersFile = playersPath.toFile();  //convert path object to file oject
        players = this.getAll();  //get list of all players
    }
    /**
     * getAll method 
     * @return a list of Player objects for all players stored in the file
     * try-with-resources statement automatically closes the input stream
     * IOException is thrown if operation fails
     */
    @Override
    public List<Player> getAll(){ //if already read, don't read file again
        if (players != null){ //check if player li
            return players;
        }
        players = new ArrayList<>(); // create empty ArrayList of Player objects
         //check if player file exists
        if(Files.exists(playersPath)){
            try (BufferedReader in = new BufferedReader(
                                    new FileReader(playersFile))){
                String line = in.readLine(); //read player line into String variable
                while(line != null) { //process until end of file reached
                   
                     //split string into fields
                    String[] fields = line.split(FIELD_SEP);
                    String playerName = fields[0];
                    String money = fields[1];
                    String password = fields[2];
                    
                    //create new player object from field values:
                    Player p = new Player(
                        playerName, Double.parseDouble(money), password);
                    players.add(p); //add player object to array list
                    line = in.readLine();  //reads next line in file
                }
            } catch (IOException e){
                System.out.println(e); //test if successful
            }
        } else {
            System.out.println(
                playersPath.toAbsolutePath() + " does not exist");
            return null;
        }
        return players;
    }
    /**
     * Method to return Player object matching specific Player name
     * @param playerName
     * @return player if matches/ otherwise returns null
     */
    @Override
    public Player get(String playerName){
        for (Player p : players) {
            if (p.getPlayerName() .equals(playerName)){
                return p;
            }
        }
        return null;
    }
    
    /**
     * Method to write data to the Players file using a loop to write each 
     * individual player in the list, separated by the delimiter constant
     * println method to insert a new line character after each player record
     * IOException returns false if the save operation fails
     * @return 
     */
    private boolean saveAll(){
        //Connect to Player's file:
        try (PrintWriter out = new PrintWriter(
                                new BufferedWriter(
                                new FileWriter(playersFile)))){
            /** write all players in list to file using a loop to write each 
             * player in the list to the file, separated by the delimiter*/
            for (Player p : players){
                out.print(p.getPlayerName() + FIELD_SEP);
                out.print(p.getMoney() + FIELD_SEP);
                out.println(p.getPassword());
            }
            return true;
        } catch (IOException e){
            System.out.println(e);
            return false;
        }
    }
    /**
     * Method to add player to the Player's file
     * @param p individual player object
     * @return true only if the saveAll method also returns true, player added
     */
    
    @Override
    public boolean add(Player p){
        players.add(p);
        return this.saveAll();
    }
    
    /**
     * Method to delete player object from file
     * @param p individual player object
     * @return true only if saveAll method also returns true, player deleted
     */
    @Override
    public boolean delete(Player p){
        players.remove(p);
        return this.saveAll();
    }
    
    /**
     * Method to update individual player, by finding index through player name,
     * removing player record from file and replacing with updated info
     * @param newPlayer new player name to update
     * @return true only if saveAll also returns true, record updated
     */
    @Override
    public boolean update(Player newPlayer){
        Player oldPlayer = this.get(newPlayer.getPlayerName());
        int i = players.indexOf(oldPlayer);
        players.remove(i);
        players.add(i, newPlayer);
        return this.saveAll();
    }
    
   
    
}
