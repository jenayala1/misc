
package wordSwap;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.Scanner; 

public class WordSwap {

    public static void main(String[] args) {
        System.out.println("Secret Code Applicstion #1\n");
        LocalDate todaysDate = LocalDate.now();     
   
        Scanner sc = new Scanner(System.in);
        System.out.println("What English sentence would you like to convert to "
                + "secret code #1? ");
        String userSentence = sc.nextLine();
              
        //Call methods to process user input
        wordCount(userSentence);
        formatTodaysDate(); 
        wordSwap(userSentence); 
        formatFutureDate(todaysDate);    
    }

    public static int wordCount(String userSentence){  
        if (userSentence == null || userSentence.isEmpty()){
            return 0;
        }
        int wordCount = 0;  
        userSentence = userSentence.trim();
        
        for(int i = 0; i < userSentence.length(); i++){     
            if(userSentence.charAt(i) != ' '){ 
                 wordCount++;
                 while(userSentence.charAt(i) != ' ' && i < userSentence.length() -1){
                     i++;
                 }        
            }
        }       
       return wordCount;
       
    }    
             
    public static void wordSwap(String userSentence){     
        int stringLength = userSentence.length();
        int lastCharacter = userSentence.length() -1;  
               
        //get last word
         for (int i= 0; i < userSentence.length(); i++){ 
             
            //loop through to find last character of each word
            if (i == userSentence.length() -1)  
               System.out.print(userSentence.charAt(i));
             
            if (i == 0)
                System.out.print(userSentence.charAt(i));
       
            if (userSentence.charAt(i) == ' '){ 
                System.out.print(userSentence.charAt(i));
                System.out.print( " " + userSentence.charAt(i - 1) + userSentence.charAt(i + 1) );
            }
        }
    }
  
    public static void getNumber(String userSentence, int wordCount){
        int number = wordCount;
        for(int i = 0; i < userSentence.length(); i++){     
            if(userSentence.charAt(i) == ' '){            } else {
                while(userSentence.charAt(i) != ' ' && i < userSentence.length()){
                    number--; 
                }      
             System.out.print(" " + i + " ");
            }   
        }           
     } 

    public static void formatTodaysDate(){
        LocalDate todaysDate = LocalDate.now();
        int currentDay = todaysDate.getDayOfMonth();
        int currentMonth = todaysDate.getMonthValue();
        int currentYear = todaysDate.getYear();    
        System.out.print(currentYear + " " + currentMonth + " " + currentDay + " ");   
    }
    
    public static void formatFutureDate(LocalDate todaysDate){       
        //Next month's number:
        LocalDate futureMonth =  todaysDate.plus(1, ChronoUnit.MONTHS);
        int futureMValue = futureMonth.getMonthValue(); 
        
        // Day before current day:
        LocalDate previousDay = todaysDate.minus(1, ChronoUnit.DAYS);
        int futureDay = previousDay.getDayOfMonth();
        System.out.print(" " + futureMValue + " " + futureDay + " ");       
        System.out.println(Year.now().format(DateTimeFormatter.ofPattern("uu"))+ "20");       
    }
}
