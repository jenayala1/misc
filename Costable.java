/* COSC-1337-Jennifer Ayala--7/6/2019--Mid-Term Programming Exam--
* This application calculates and displays the starting and ending daily 
* corner store inventory stock of produce and dry goods--
* @author Jennifer Ayala
* @version 1.0.0
* Step 8: Create the Costable interface to specify methods used with the inventory*/

package Ayala.interfaces; //Step 16: move to interface package

public interface Costable {
    
    //Step 11: add methods for getting & setting balance
    //get Method to get balance
    double getBalance();
    
     /**
     * Sets the balance amount.
     * @param amount a <code>double</code> value for the inventory item balance
     * amount */
    void setBalance(double amount);
}
