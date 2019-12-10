/**INEW-2338-001/COSC 2336-001--Jennifer Ayala--11/10/2019--Programming Project Quiz 2
 * Create an app to allow users to enter a guess and wage after selecting a player
 * for a random number selection game, update balance thru a GUI and write 
 * results to a file
 * This file validates user input -- Console.java 
*/
package ui;
import java.util.Scanner; //import statement to access the Scanner class for user input
/**
 * The <code>Console</code> class provides methods to obtain and validate user input 
 * @author Jennifer Ayala
 * @version 1.0.0
*/

public class Console {

    private static Scanner sc = new Scanner(System.in);
    
    /** Displays the prompt to the console, uses <code>Scanner</code> object
     * to obtain <code>String</code> from the user, validates is a string entry
     * @param prompt <code>String</code> string message displayed to user
     * @return  <code>String</code> string entered by user
     */
    public static String getString(String prompt) {
        String s = "";
        boolean isValid = false;
        while (!isValid) {
            System.out.print(prompt);
            if (sc.hasNext()) {
                s = sc.nextLine(); // read entire line
                isValid = true;
            } else {
                System.out.println("Error! Invalid string value. Try again.");
            }
        }
        return s;
    }

     /** Displays the prompt to the console, uses <code>Scanner</code> object
     * to obtain <code>Double</code> value from the user, validates input is a double
     * @param prompt <code>String</code> string message displayed to user
     * @return  <code>Double</code> value entered by user
     */
    public static double getDouble(String prompt) {
        double d = 0;
        boolean isValid = false;
        while (!isValid) {
            System.out.print(prompt);
            if (sc.hasNextDouble()) {
                d = sc.nextDouble();
                isValid = true;
            } else {
                sc.next();     // discard the incorrectly entered double
                System.out.println("Error! Invalid decimal value. Try again.");
            }
            sc.nextLine();  // discard any other data entered on the line
        }
        return d;
    }

     /** Displays the prompt to the console, uses <code>Scanner</code> object
     * to obtain <code>Double</code> from the user, validates entry is within the specified range
     * @param prompt <code>String</code> string message displayed to user
     * @param min <code>Double</code> double value specifying minimum value in range
     * @param max <code>Double</code> double value specifying maximum value in range
     * @return  <code>Double</code> double value entered by user
     */
    public static double getDouble(String prompt, double min, double max) {
        double d = 0;
        boolean isValid = false;
        while (!isValid) {
            d = Console.getDouble(prompt);
            if (d <= min) {
                System.out.println(
                        "Error! Number must be greater than " + min + ".");
            } else if (d >= max) {
                System.out.println(
                        "Error! Number must be less than " + max + ".");
            } else {
                isValid = true;
            }
        }
        return d;
    }

     /** Displays the prompt to the console, uses <code>Scanner</code> object
     * to obtain <code>int</code> value from the user & validate input is an integer
     * @param prompt <code>String</code> string message displayed to user
     * @return  <code>int</code> integer value entered by user
     */
    public static int getInt(String prompt) {
        boolean isValid = false;
        int i = 0;
        while (!isValid) {
            System.out.print(prompt);
            if (sc.hasNextInt()) {
                i = sc.nextInt();
                isValid = true;
            } else {
                sc.next();  // discard invalid data
                System.out.println("Error! Invalid integer value. Try again.");
            }
            sc.nextLine();  // discard any other data entered on the line
        }
        return i;
    }

     /** Displays the prompt to the console, uses <code>Scanner</code> object
     * to obtain <code>int</code> from the user, validates entry is within the specified range
     * @param prompt <code>String</code> string message displayed to user
     * @param min <code>int</code> integer value specifying minimum value in range
     * @param max <code>int</code> integer value specifying maximum value in range
     * @return  <code>int</code> integer value entered by user
     */
    public static int getInt(String prompt, int min, int max) {
        int i = 0;
        min = 1;
        max = 5;
        boolean isValid = false;
        while (!isValid) {
            i = Console.getInt(prompt);
            if (i <= min) {
                System.out.println(
                        "Error! Number must be greater than " + min + ".");
            } else if (i >= max) {
                System.out.println(
                        "Error! Number must be less than " + max + ".");
            } else {
                isValid = true;
            }
        }
        return i;
    }     
}