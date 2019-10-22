/* COSC-1337-Jennifer Ayala--7/6/2019--Mid-Term Programming Exam--
* This application calculates and displays the starting and ending daily 
* corner store inventory stock of produce and dry goods--
* @author Jennifer Ayala
* @version 1.0.0
* --Step 12: Create an inventory class that implements the interfaces: Inventory.java  */
package Ayala.business; // Step 17, move to business interface

/*import packages to access classes and data */
import Ayala.interfaces.Costable; 
import Ayala.interfaces.Removeable;
import Ayala.interfaces.Addable;

/** Class declaration - implements multiple interfaces:
* Addable, Removeable, & Costable */
public abstract class Inventory implements Addable, Removeable, Costable {
    private String inventoryName;
    private double amount;
    private double balance;
    
    //default Constructor
    public Inventory(){
        
    }
    
    //Constructor with parameters: inventoryName & balance
    public Inventory(String inventoryName, double balance){
        this.inventoryName = inventoryName;
        this.balance = balance;
        
    }
    
     public void setInventoryName(String inventoryName) {
        this.inventoryName = inventoryName;
    }

    public String getInventoryName() {
        return inventoryName;
    }
    
    @Override
    public void setBalance(double balance){
        this.balance = balance;
    }
    
    @Override
    public double getBalance(){
        return balance;
    }
}
