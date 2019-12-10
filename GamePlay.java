//project quiz - possible application start
/**INEW-2338-001/COSC 2336-001--Jennifer Ayala--11/10/2019--Programming Project Quiz 2
 * Create an app to allow users to enter a guess and wage after selecting a player
 * for a random number selection game, update balance thru a GUI and write
 * results to a file
 * This file defines the GUI interface and interaction with the user --GamePlay.java 
*/

package ui;

/**
 * The <code>GamePlay</code> class implements the application GUI & updates the
 * player object, contains instance variables, constructor, 
 * @author Jennifer Ayala
 * @version 1.0.0
*/
import java.util.*;
import java.util.Random;  //access the random class for number generator
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
import javax.swing.*;
import java.text.NumberFormat;
import business.Player;  //access to the Player object class
import db.PlayerDAO;     // access to the PlayerDAO interface
import db.PlayerTextFile;  //ability to read & write to the player text file
import java.nio.file.Paths;
import java.util.List;
 

public class GamePlay extends JFrame {
   //create the player file
   //private PlayerDAO playerTextFile = new PlayerTextFile();
    
   private JComboBox playerCombo; //declare variable to select user from combobox from Player object
   private JTextField playerNameTF; //field to move player name from player object
   private JTextField playerBalanceTF; //text field to add player balance from player object
   private JTextField wagerTF; //declare variable text field for user to input wager
   private JTextField guessTF; // declare variable text field to enter a guess
   private JTextField randomNumTF; //declare variable text field to display random number 
   private JTextField resultTF;  //declare variable text field to display result of guess
    
    /**
     * @param args the command line arguments
     */
    public GamePlay (){
        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException |
                 IllegalAccessException | UnsupportedLookAndFeelException e) {
            System.out.println(e);
        }
        initComponents();
    }
     
    
   //@SuppressWarnings("empty-statement")
    private void initComponents() {
        setTitle("Game Play");  //create the GUI frame title
        setLocationByPlatform(true); //allow OS to set frame location
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //exit application on close
       
        //retrieve Player object data from the PlayerTextFile:
        //List<Player> players = PlayerTextFile.getAll();
       
        //temp code to test comboBox 
        String [] players = {" ", "John Doe", "Mary Smith"}; 
        
        //create the textField and JComboBox objects from variables:
        playerCombo = new JComboBox(players);
        
        //Add object to playerCombo box:
        //playerCombo.getItem(players);
        
        
        playerNameTF = new JTextField();
        playerNameTF.setEditable(false); //read only once name retrieved from player object
        
        playerBalanceTF = new JTextField();
        
        // pending: add balance from player text file
        //playerBalanceTF.setText(); 
        playerBalanceTF.setEditable(false); //read only once balance retrieved from player object
        
        wagerTF = new JTextField(); //user input field for wager
        guessTF = new JTextField(); //user input field for guess
        
        randomNumTF = new JTextField();
        randomNumTF.setEditable(false); //set display field to read only for random number
        
        resultTF = new JTextField();
         resultTF.setText("");
        resultTF.setEditable(false); //displays the result of the guess - win or lose
       
        //Set the height & weight dimensions
        Dimension dim = new Dimension(150, 20);
        playerNameTF.setPreferredSize(dim);
        playerBalanceTF.setPreferredSize(dim);
        wagerTF.setPreferredSize(dim);
        guessTF.setPreferredSize(dim);
        randomNumTF.setPreferredSize(dim);
        resultTF.setPreferredSize(dim);
        
        playerNameTF.setMinimumSize(dim);
        playerBalanceTF.setMinimumSize(dim);
        wagerTF.setMinimumSize(dim);
        guessTF.setMinimumSize(dim);
        randomNumTF.setMinimumSize(dim);
        resultTF.setMinimumSize(dim);
        
        //Create the exit button:
        JButton exit = new JButton("Exit"); //create button object
        exit.addActionListener(e -> {
            exitButtonClicked(); //Exit button method
         });
        
        //create spin the wheel button:
        JButton spin = new JButton("Spin the Wheel"); //create button object
        spin.addActionListener(e -> {
            spinWheel(); //Spin the wheel method
        });
        
        //create Play Again button:
        JButton playAgainB = new JButton("Play Again"); //create button object
        playAgainB.addActionListener(e -> {
           playAgain();  //calls the play again method 
        });
        
        //set up button panel
        JPanel buttonPanel = new JPanel();   //create new panel for the buttons
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT)); //align right
        buttonPanel.add(spin); //add spin wheel button to the panel
        buttonPanel.add(playAgainB); // add play agaon button to panel
        buttonPanel.add(exit);     // add exit button to the panel
        
        //Create main panel:
        JPanel main = new JPanel(); //main panel to add each panel
        main.setLayout(new GridBagLayout()); //align left
        main.add(new JLabel("Select a player:"), getConstraints(0, 0)); //label for player 
        main.add(playerCombo, getConstraints(1, 0)); //add the player object to the panel
        main.add(new JLabel(" Player Name: "), getConstraints(0, 1));
        main.add(playerNameTF, getConstraints(1, 1));
        main.add(new JLabel("Enter a wager amount"), getConstraints(0, 2)); //label for wager
        main.add(wagerTF, getConstraints(1, 2)); //add wager text field to panel
        main.add(new JLabel("Enter one guess between 1 - 5"), getConstraints(0, 3));
        main.add(guessTF, getConstraints(1, 3)); //text field for the guess
        main.add(new JLabel("The Winning Number Is: "), getConstraints (0, 5));
        main.add(randomNumTF, getConstraints(1, 5)); //add the randomly generated number
       // main.add(resultTF, getConstraints(1, 6)); // add the result response
   
        
        //add panels to the BorderLayout of the frame:
        add(main, BorderLayout.CENTER); //add to the center of the frame
        add(buttonPanel, BorderLayout.SOUTH); //position at the bottom of the frame
        setSize(320, 200);
        pack(); //set the size of the frame to accommodate all components
       
    }
       
    // helper method for getting a GridBagConstraints object
    private GridBagConstraints getConstraints(int x, int y) {
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.LINE_START;
        c.insets = new Insets(5, 5, 0, 5);
        c.gridx = x;
        c.gridy = y;
        return c;
    }
     
    //Create the exit button method:
    private void exitButtonClicked(){
        System.exit(0); //exit application with status code of 0
    }
    
    /**create the spin the wheel method for the button event
    * generates random number between 1-5 */
    private void spinWheel(){
        String message = ""; //declare variable for alert message
        int winningNumber = (int) (Math.random()*(6-1)+1);
        String wNumber = Integer.toString(winningNumber);
        String guess = guessTF.getText();
        int gNumber = Integer.parseInt(guess);
       
        if(gNumber < 1 || gNumber > 5){
            message = "Please enter a number between 1 and 5";
            playAgain();
        } else {
             randomNumTF.setText(wNumber);
             if (guess == wNumber){
                message = "Winner";
            } else if (guess != wNumber) {
                message = "Loser";
            }
        }
        //display the message:
        JOptionPane.showMessageDialog(this, message);
       
    }
    
    /** create the play again method for the button event, reset the fields - by 
     * setting text fields to empty strings & update the record*/
    private void playAgain(){
        playerCombo.setSelectedIndex(0);
        playerNameTF.setText("");
        wagerTF.setText("");
        guessTF.setText("");
        randomNumTF.setText("");
        resultTF.setText("");
         
         //Pending: update the balance & player record
         //player = playerCombo.getSelectedItem(players);
         //updateBalance();
    }
    
    /**
    * Method to update player record the file - convert double data type
    * to post string data retrieved from text fields
    */
    private void updateBalance(){   
        //set variable to capture balance from player object
        double balance = Double.parseDouble(playerBalanceTF.getText());   
        
        //set variable to capture wager from entry
        double wage = Double.parseDouble(wagerTF.getText()); 
        balance += wage; //new balance equal original balance plus wage
        
        //set number format to currency for price with NumberFormat object:
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        playerBalanceTF.setText(currency.format(balance)); 
    }
    
    //main method to run the program
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new GamePlay().setVisible(true);          
        });
    }
    
}
