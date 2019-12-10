/**INEW-2338-001/COSC 2336-001--Jennifer Ayala--9/16/2019--Project Quiz 1
 * Build an app to enable users to add players, place wagers & 3 number guesses
* This app contains the main method & game play validation methods--CasinoApp.java */

package casinoapp;
import java.util.*;
import java.util.Random;    //access Random class for number generator
import java.util.ArrayList; //access ArrayList class for Player objects
import java.util.LinkedList;  //access LinkedList class for winning numbers
import java.util.Arrays;     //access the array class

import java.util.Scanner; //import statement to use scanner class for user input

//Step 10 - implement the interface GamePlayer
public class CasinoApp implements GamePlayer {

    // main method to declare & initialize entities & control execution of code
    public static void main(String[] args) {
        CasinoApp casinoApp = new CasinoApp();
        int numberPlayers = 0; //initialize number of players to 0 to start
        String playerName = ""; //initialize playerName
        //player variable stores data for player object
        Player player = new Player(); 
        String choice = "yes"; //initialize choice to yes default to start program
        
       //Step 16: Store player object as ArrayList
       //commented out due to errors & revised all methods below to pass Player object
        //ArrayList<Player> player = new ArrayList<>();
        
        Random random = new Random(); //random generator object
        while (choice.equalsIgnoreCase("yes")){
            // Step #18 - display a welcome message & run welcome method
            System.out.println("Welcome to the Casino App");
            System.out.println();
            welcome(player);
            winner(playerName, player);
            keepPlaying(choice, player);
        } 
    
       
    }
    
    // method to generate a value beterrn 0 & 20
    public static Random randomNumGen() {
        Random random = new Random(); //create new random object  
        return random;
    }
    
    // method to display initial welcome display & user input
    public static int welcome(Player player){
       
        // get the input from the user
        int numberPlayers = Console.getInt(
                    "How many players are in the game? ");
        //verify number of players entered - for testing purposes
        //System.out.println("There are " + numberPlayers + " in the game");
        createPlayer(numberPlayers, player);
        return numberPlayers;
    }
     //method to create player - prompt, accept & validate user input
    public static Player createPlayer(int numberPlayers, Player player){
        //set counter variable to 0
        int k = 0;
        do {
            player = new Player();
            String playerName = Console.getString("Enter a player's name:  ");
            player.setName(playerName);
            double amount = Console.getDouble("How much money is " + playerName +
                     " willing to put on the table?  ");
            player.setAmount(amount);  
            k++; //player counter to increment
           validateGuess(playerName, amount, player);
        } while(k < numberPlayers);
        return player;
    }
     //method to display, accept & validate guess prompt
    public static int[] validateGuess(String playerName, double amount, 
            Player player){
        //prompt user to guess numbers:
        System.out.println(playerName + " you must play three numbers at a time. "
                + " The valid numbers are between 0 and 20 inclusive");
        int[] guess = new int[3]; //initialize guess as array of 3 elements
    
        String prompt = " enter your number "; //default prompt
        // specify array index for each guess - user input
        guess[0] = Console.getPlayerGuess(playerName + prompt);  
        guess[1] = Console.getPlayerGuess(playerName + prompt);
        guess[2] = Console.getPlayerGuess(playerName + prompt);
        player.setGuesses(guess); //set player object guess elements
        validateWager(playerName, amount, guess, player);
        return guess;
        
    }
    
    //method to display, accept & validate the wagering information
    public static double validateWager(String playerName, double amount, 
            int[] guess, Player player){  
        System.out.println(", you may place a"
                + " single bet of any size on these numbers as long as you "
                + "have that much money on the table");
        double playerWage = 0; //initialize to 0
        boolean isValid = false;
        while(!isValid){
            String prompt = " how much do you wager?  ";
            playerWage = Console.getDouble(playerName + prompt);
            if (playerWage > amount){ //validate wager is less than player has
                 System.out.println(playerName + ", you do not have $" + playerWage +
                    " on the table to bet. Try a lower wage"); 
             } else if (playerWage < 0){ //confirm is entering a wager
                 System.out.println(playerName + ", you cannot wager less than 0 dollars"
                    + " Try a higher wage");         
             }else {
                isValid = true; //input meets criteria
                System.out.println("Very good. Spinning wheel ");
            }
          
        } return playerWage;
         
    }
    
    
    //method to determine if player wins or loses & displays results to player
    public static boolean winner(String playerName, Player player){
       player.getGuesses();
       player.getAmount();
       Random random = randomNumGen();
        boolean result = false;
        //use a LinkedList to store the winning numbers
        LinkedList<Integer> winningNumbers = new LinkedList<>();
        for (int i = 0; i < 20; i++){
            //add randomly generated numbers to specific index, add 1 to initial 
            // int i to ensure value is greater than 0
            winningNumbers.add(0, random.nextInt(i+1)); 
            winningNumbers.add(1, random.nextInt(i+1)); 
            winningNumbers.add(2, random.nextInt(i+1)); 
        }      
        System.out.println("The winning numbers are: ");
        System.out.println(winningNumbers.get(0) + " " + winningNumbers.get(1)
             + " " + winningNumbers.get(2));
       
       //pending: compare guess to winning number & determine outcome 
        //winner code pending: guess[] == winningNumbers 
        System.out.println("Sorry " + playerName + " you lose. You have $ "
                + "left on the table ");
        //loser code pending : guess[] != winningNumbers
        //double balance = amount - wager;
        return result; 
    }
     
   
    
    //method to prompt, accept & validate data to continue playing
    public static String keepPlaying(String choice, Player player){    
        String playerName = player.getPlayerName();
        player.getAmount();
        player.getWager();
       
    // see if the user wants to continue - unresolved - error, not allowing user input
        System.out.println("Play again? (yes/no): ");
        Scanner sc = new Scanner(System.in);
        if (choice.equalsIgnoreCase("no")) {
            System.out.println(playerName + "'s balance is $");
            //printPlayer();
        } else {
            System.out.println("You must enter yes or no. Try again");
        }
        return choice;
    }
    //method to print player's names & ending balances
    @Override
    public void printPlayer(){
        // Pending player's ending balances
        System.out.println("Take your money off the table when you leave. Come"
                + " back soon. ");
    }
}
