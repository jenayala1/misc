/**INEW-2338-001/COSC 2336-001--Jennifer Ayala--10/14/2019--Mid-Term-Project
 * Create an app to allow users to create a txt file to store data values
 * associated with Player objects
*/

package ui;
import business.Player;       //access the Player object class
import db.PlayerDAO;         //access the PlayerDAO interface
import db.PlayerTextFile;   //access the PlayerTextFile class
import java.util.List;     // access the list interface
import java.lang.Math;     // access the random method from the math class
import java.lang.StringBuilder; //access to the StringBuilder class to modify strings

/**
 * The <code>ProgramManagerApp</code> class provides methods to interact with 
 * the user, contains the main method to start the program and collect user input  
 * @author Jennifer Ayala
 * @version 1.0.0
*/

public class ProgramManagerApp {
    //create the player file
    private static PlayerDAO playerFile = new PlayerTextFile();
    
    public static void main(String[] args) {
       // Welcome messgae to application
        System.out.println("Welcome to the Player Manager\n");
        displayMenu(); //method to display menu options
      
        //Loop that continues until user enters the exit command:
        String action = ""; //declare action for menu command
        //while-loop to continue as long as "exit" is not entered
        while(!action.equalsIgnoreCase("exit")){
            action = Console.getString("Enter a command: "); //get user input
            System.out.println(); //spacing 
            
            if (action.equalsIgnoreCase("encrypted list")){
                displayEncrypted();
            } else if (action.equalsIgnoreCase("decrypted list")){
                displayDecrypted();
            } else if (action.equalsIgnoreCase("add")){
                addPlayer();
            } else if (action.equalsIgnoreCase("update")){
                updatePlayer();
            } else if (action.equalsIgnoreCase("del")){
                deletePlayer();
            } else if (action.equalsIgnoreCase("help") ||
                        action.equalsIgnoreCase("menu")){
                displayMenu();
            }  else if (action.equalsIgnoreCase("exit")){
                 System.out.println("Bye.\n");
            } else {
                System.out.println("Error! Not a valid command");
            }
        }
        
    }
      /**Step #5 - Display menu of options  */
        public static void displayMenu() {
            System.out.println("COMMAND MENU");
            System.out.println("encrypted list  - List all players with encrypted password");
            System.out.println("decrypted list  - List all players with decrypted password");
            System.out.println("update - update a player");
            System.out.println("add     - Add a player");
            System.out.println("del     - Delete a player");
            System.out.println("help    - Show this menu");
            System.out.println("exit    - Exit this application\n");
        }   
      
      /** 
       * Method to display all players with encrypted passwords as stored to file:
       */  
        public static void displayEncrypted(){
            System.out.println("PLAYER LIST ");
            List<Player> players = playerFile.getAll();
            StringBuilder sb = new StringBuilder ();
            //Loop through player objects
            for (Player p : players){
                //use the StringUtils class to format spacing & alignment:
                sb.append(StringUtils.padWithSpaces(p.getPlayerName(), 20));
                sb.append(StringUtils.padWithSpaces(p.getMoneyFormatted(), 10));
                sb.append(p.getPassword());
                sb.append("\n");           
            }
            System.out.println(sb.toString());
        }
        
           /** 
       * Method to display all players with decrypted passwords: pending decryption
       */  
        public static void displayDecrypted(){
            System.out.println("PLAYER LIST ");
            List<Player> players = playerFile.getAll();
            StringBuilder sb = new StringBuilder ();
            //Loop through player objects
            for (Player p : players){
                //use the StringUtils class to format spacing & alignment:
                sb.append(StringUtils.padWithSpaces(p.getPlayerName(), 20));
                sb.append(StringUtils.padWithSpaces(p.getMoneyFormatted(), 10));
                sb.append(p.getPassword());
                sb.append("\n");           
            }
            System.out.println(sb.toString());
        } 
        
        
        
      /**
       * Method to create player and add to the Player's file, takes in the name,
       * money on table, and password
       */  
        public static void addPlayer(){ //call the addPlayer method
            //get input from user:
            String playerName = Console.getString("Enter player's full name:\n");
            double money = Console.getDouble("Enter player's money on table: ");
            String password = Console.getString("Enter a password 8 - 20 characters: ");
            encryptPW(password, playerName);
            
            Player player = new Player(); //create a player object
           
            //use setter methods to define player
            player.setPlayerName(playerName);
            player.setMoney(money);
            //set password with the encryptPW method, passing password & playerName as parameters
            player.setPassword(encryptPW(password, playerName)); 
            
            //pass the player object to the add method of the PlayerTextFile class
            playerFile.add(player); 
            
            System.out.println(playerName + " has been added. \n");
        }
        
        /**
         * Method to delete player from the file
         */
        public static void deletePlayer(){ //call deletePlayer method
            //get user input to identify player name to delete
            String playerName = Console.getString("Enter player's name to delete: ");
            
            //get method to locate player object
            Player p = playerFile.get(playerName);
            
            //validate user input to ensure player name exists:
            if (p != null){
                //call delete method of the PlayerTextFile class to remove player
                playerFile.delete(p);
                System.out.println(p.getPlayerName() + " has been deleted. \n");
            } else {
                //display error message if input does not match existing records
                System.out.println("No player by that name.\n");
            }        
        }
      
        /**
         * Method to update player record the file - currently only updates the 
         * player name, pending additional details
         */
        public static void updatePlayer(){
            //get user input to identify player name to edit
            String playerName = Console.getString("Enter player's name to update: ");
            
             //get method to locate player object
            Player p = playerFile.get(playerName);
            
             //validate user input to ensure player name exists:
            if (p != null){
                // get new info & update file:
                String pNew = Console.getString("Enter updated name: ");
                 //use setter methods to define player
                p.setPlayerName(pNew);
                 
                //call update method of the PlayerTextFile class to edit player name
                playerFile.update(p);
               
                System.out.println(p.getPlayerName() + " has been updated. \n");
            } else {
                //display error message if input does not match existing records
                System.out.println("No player by that name.\n");
            }        
        }
        
        /**
         * Method to encrypt player password, executed on the add player command
         * and stored to the file
         * @param p <code>String</code> string password from user input
         * @return password converted from encryption algorithm
         */
        
        public static String encryptPW(String p, String u){
           // Console.validatePassword(p); //not working correctly
            String oldPWD = p; //create variable to store original entry
            String user = u;
            char char1 = user.charAt(0); //get 1st character of user name
            int oldPWDLenght = p.length(); //get size of the password
            String pwd1 = p.substring(1) + p.charAt(0); //move 1st character to end
            
            //move new 1st character to the end
            String pwd2 = pwd1.substring(1) + pwd1.charAt(0); 
            StringBuilder sb1 = new StringBuilder(pwd2); //create strinbuilder from the string
            int sbLength = sb1.length();
            
            double rValue = Math.random(); //variable generates a random number
            rValue = rValue * 10 + 1; //between 1 & 10
            int randomV = (int) rValue; //cast double to an int value
            
            sb1.insert(2, randomV); //insert the random value at index 3, push rest back
            sb1.insert(6, "*"); // insert an asterik in index 7
            sb1.append(char1); //add the first character of the name to the end of the string
            String pwd3 = sb1.toString(); //convert to string
            String password = pwd3; //set the new encrypted password
            //test line to ensure encryption is working
            //System.out.println("Encrypted password " + oldPWD + " is now: "+ password);
        return password;
    }  
     
        
          
}
