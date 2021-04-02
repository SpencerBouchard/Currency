package util;

import java.util.Scanner;

/**
 * This file consists of methods to be used as utilities in presenting 
 * an introduction to a given programs.
 *
 * @author Spencer Bouchard
 */
public class Utilities {
 
    /**
     * Prints a phrase before pausing and ending the program.
     * 
     * @param pausePhrase 
     */
    public static void pause(String pausePhrase){
    
        Scanner keyboard = new Scanner(System.in); 

        System.out.print(pausePhrase);
        keyboard.nextLine();
        System.exit(0);
      
    } // end of method pause
    
    /**
     * Displays my general background and information as well as what a program 
     * does and instructions if needed.
     * 
     * @param myName      My first and last name
     * @param schoolInfo  The university I attended, degree and major I acquired
     * @param email       The email I can be reached at
     * @param programInfo What the program does and possibly instructions 
     */
    public static void displayInfo(String myName, String schoolInfo, 
        String email, String programInfo){
    
        System.out.println("My information:");
        System.out.println(myName);      
        System.out.println(schoolInfo);
        System.out.println(email);
    
        System.out.println(programInfo + "\n");
    
    } // end of method displayInfo
    
} // end of class utilities
