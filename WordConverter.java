/** COSC-1337-001--Jennifer Ayala--07/29/2019--Final Project:  
* Create an application that reads and converts English sentences to a secret
*  code according the specs given; this file starts the application
* WordConverter.java 
*/ 
package wordconverter;

// import statements for appropriate classes to use date/time methods/objects:
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.lang.StringBuilder; // to access the StringBuiler class to process string
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.Scanner; //import statement to use the scanner class for user input

public class WordConverter {

    public static void main(String[] args) {
        //Intro/Welcome Display Message
        System.out.println("Secret Code Applicstion #1\n");
        
        //Step 12: determine current date so it will change each day of use
        LocalDate currentDate = LocalDate.now();     
            
        // Step #6 - Get input from the the user
        Scanner sc = new Scanner(System.in);
        //Prompt user:
        System.out.println("What English sentence would you like to convert to "
                + "secret code #1? ");
        String eSentence = sc.nextLine(); //get sentence from user as a string
              
        // call the countWords function, passing the user input as the parameter
        countWords(eSentence);
        
        //call method to process current date to display before coded word
        formatCurrentDate(); 
        
        //Call the convertString method to re-arrange words
        convertString(eSentence); 
        
        //Call to swap must incorporated with the loop to separate the words
        // System.out.print(swap(eSentence, 0, eSentence.length() -1));
        
        //Call to the end date method after re-arranged words
        formatEndDate(currentDate);
      
    }
    
    //Step #7:Count Words Method - determine number of words in sentence
    public static int countWords(String eSentence){
       //if user doesn't input data, return 0    
        if (eSentence == null || eSentence.isEmpty()){
            return 0;
        }
        int wordCount = 0; //declare & initialize word count to 0  
        eSentence = eSentence.trim(); //remove leading & trailing spaces
        
        //loop setting boundry less than string lenth
        for(int i = 0; i < eSentence.length(); i++){     
            if(eSentence.charAt(i) != ' '){ //variable index begins after space
                 wordCount++;
                 while(eSentence.charAt(i) != ' ' && i < eSentence.length() -1){
                     i++;
                 }        
            }
        } 
       //Display to console to verify wordCount is working: 
       System.out.println("There are " + wordCount + " words in sentence entered");  
       return wordCount;
       
    }    
    
    /**Step #8: In-process method - for each word, move the last letter to the 
     *  beginning of the coded word followed by the remaining letters in the 
     * word with the appropriate number before the last letter of the coded word*/
         
    public static void convertString(String eSentence){     
        int strLength = eSentence.length(); //length of string input by user
        int lIndex = eSentence.length() -1;   //character of last word
        
        //Pending use - split sentence characters into string objects with space as the delimiter
        //String [] sWords = eSentence.split(" ");
         
        // for loop to cycle through characters of each word to find last word
         for (int i= 0; i < eSentence.length(); i++){ 
             
            //loop through to find last character of each word
            if (i == eSentence.length() -1)  
               System.out.print(eSentence.charAt(i));
             
            if (i == 0)
                System.out.print(eSentence.charAt(i));
       
            if (eSentence.charAt(i) == ' '){ 
                System.out.print(eSentence.charAt(i));
                //variable pending to hold new string with re-arranged word    
               // String finalS = eSentence.charAt(i-1) + " " + eSentence.charAt(i + 1);
                
                //Pending :display new string with first & last letter --pending rest of word **rewrite with corrected string**
                System.out.print( " " + eSentence.charAt(i - 1) + eSentence.charAt(i + 1) );
            }
        }
    }
     /**Method in-process--causing errors
    public static String swap(String eSentence, int i){
        StringBuilder sb = new StringBuilder(eSentence);
        sb.setCharAt(i, eSentence.charAt(0));
        return sb.toString();
    }
    */
    
    /**Step 9: In-Process: method-determine appropriate number by number of words
    * in the sentence, decreasing the number for each subsequent word
    * PENDING: incorporate into string*/
    public static void getAppNumber(String eSentence, int wordCount){
        int appNumber = wordCount;
        for(int i = 0; i < eSentence.length(); i++){     
            if(eSentence.charAt(i) == ' '){            } else {
                //variable index begins after space
                while(eSentence.charAt(i) != ' ' && i < eSentence.length()){
                    appNumber--; //reduce the count on each loop
                }      
             System.out.print(" " + i + " ");
            }   
        }           
     } 
    
    //Method to format current date to display before coded word
    public static void formatCurrentDate(){
        LocalDate currentDate = LocalDate.now();
        int cYear = currentDate.getYear();
        int cMonth = currentDate.getMonthValue();
        int cDay = currentDate.getDayOfMonth();
        
        //Step 10: print current date before coded word in YYYY MM DD format
        System.out.print(cYear + " " + cMonth + " " + cDay + " ");   
    }
    
    //Step #11 - Method to format displayed date at end of coded word
    public static void formatEndDate(LocalDate currentDate){
        //Next month's number:
        LocalDate futureMonth =  currentDate.plus(1, ChronoUnit.MONTHS);
        int fMonthV = futureMonth.getMonthValue(); //format to show the month only
        
        // Day before current day:
        LocalDate previousDay = currentDate.minus(1, ChronoUnit.DAYS);
        int fDay = previousDay.getDayOfMonth();
       
        //Displays month ahead of current month, day before current day
        System.out.print(" " + fMonthV + " " + fDay + " ");
        
        //Displays current year with last 2 digits first, followed by first 2 digits
        System.out.println(Year.now().format(DateTimeFormatter.ofPattern("uu"))+ "20");       
    }
}
