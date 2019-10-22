/** COSC-1337-001--Jennifer Ayala--07/29/2019--Final Project:  
* Create an application that reads and converts English sentences to a secret
*  code according the specs given; this class process user interaction methods
* Console.java 
*/ 
package wordconverter;
import java.util.Scanner;
/**
 * The <code>Console</code> class provides methods to obtain user input 
 * @author Jennifer Ayala
 * @version 1.0.0
*/

public class Console {
     private static Scanner sc = new Scanner(System.in);
    
    public static void displayLine() {
        System.out.println();
    }

    public static void displayLine(String s) {
        System.out.println(s);
    }

    public static String getString(String prompt) {
        System.out.print(prompt);
        String s = sc.nextLine();
        return s;
    }

    public static int getInt(String prompt) {
        int i = 0;
        while (true) {
            System.out.print(prompt);
            try {
                i = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error! Invalid integer. Try again.");
            }
        }
        return i;
    }

    public static double getDouble(String prompt) {
        double d = 0;
        while (true) {
            System.out.print(prompt);
            try {
                d = Double.parseDouble(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error! Invalid decimal. Try again.");
            }
        }
        return d;
    }
}
