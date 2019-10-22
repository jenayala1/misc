/* COSC-1337-Jennifer Ayala--7/6/2019--Mid-Term Programming Exam--
* This application calculates and displays the starting and ending daily 
* corner store inventory stock of produce and dry goods--InventoryApp.java 
* @author Jennifer Ayala
* @version 1.0.0*/
package Ayala.app; 
import Ayala.presentation.Console;
import java.util.Scanner; // import utility to handle user inpute from console
public class InventoryApp { //create the InventoryApp that will display inventory info
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double pValue = 100000.00; //initialize starting produce value
        double dValue = 300000.00; 
        // display a welcome message
        System.out.println("Welcome to the Corner Store inventory application");
        System.out.println("Starting Inventory Costs");
        System.out.println("Produce inventory value: $" + pValue + " ");
        System.out.println("Dry Goods inventory value: $" + dValue + " ");
        System.out.println();
        Scanner sc = new Scanner(System.in); // creates a new scanner object
             
        String choice = "y";
        //while loop to continue prompting while choice = y
        while (choice.equalsIgnoreCase("y")) {
            // get the input from the user to determine type of inventory
            String name = Console.getInventoryName(
                    "Enter 'p' for Produce or 'd' for Dry Goods ");
               if (name.equalsIgnoreCase("p")) { //produce
                   String actionCode = Console.getActionCode( 
                    // to determine add or remove
                    "Enter 'r' to remove, or 'a' to add Produce inventory: ");
                     if (actionCode.equalsIgnoreCase("r")){
                         double amount = Console.getAmount("Enter amount to adjust: ");
                         //calculate new produce inventory
                         double pBalance = pValue - amount;
                     } else if (actionCode.equalsIgnoreCase("a")){
                         double amount = Console.getAmount("Enter amount to adjust: ");
                         //calculate new produce inventory
                         double pBalance = pValue + amount;
                     }else {
                         System.out.println("Invalid Entry");
                     } 
               } else if (name.equalsIgnoreCase("d")) { // dry goods
                   String actionCode = Console.getActionCode(
                    "Enter 'r' to remove, or 'a' to add Dry Goods inventory: ");
                     if (actionCode.equalsIgnoreCase("a")){
                         // to determine add or remove
                         double amount = Console.getAmount("Enter amount to adjust: ");
                         //calculate new dry goods inventory
                         double dBalance = dValue + amount;
                     } else if (actionCode.equalsIgnoreCase("r")){
                         double amount = Console.getAmount("Enter amount to adjust: ");
                         //calculate new dry goods inventory
                         double dBalance = dValue - amount;
                     }else {
                         System.out.println("Invalid Entry");
                     } 
                   
               } else {
                         System.out.println("Invalid Entry");
               }
                                                
             // see if the user wants to continue    
            System.out.println("Continue? (y/n): ");
            choice = sc.next();             
        }   
        /**Pending final inventory cost println statements and creating an object
         * to retrieve the methods from the appropriate class*/
    }
}
