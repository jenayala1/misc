/* COSC-1337-Jennifer Ayala--7/6/2019--Mid-Term Programming Exam--
* This application calculates and displays the starting and ending daily 
* corner store inventory stock of produce and dry goods--
* @author Jennifer Ayala
* @version 1.0.0
* Step 8: Create the removeable interface to specify methods used with the inventory*/

package Ayala.interfaces; //Step 16: move to interface package

/** Method to reduce the inventory
 * @param amount <code>double</code> 
 */
public interface Removeable {
    void out(double amount);
}
