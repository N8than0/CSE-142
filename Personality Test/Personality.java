//Nathan Gomez
//CSE 142
//TA: Noa Ferman
//3/2/2021

//This program will determine personality types by using answers
//and percentages taken from the Keirsey Temperament Sorter. It uses 
//arrays to store all of the values to be used throughout the entire program. 

import java.util.*;
import java.io.*;

public class Personality {
   public static final int DIMENSIONS = 4;
   
   //This method gets the control flow of the program by prompting the user to 
   //type in a file name and using that file name to read the data in it with a scanner.
   //After that, the program prompts for an output filename to write the data found by using
   //PrintStream.
   public static void main(String[] args) throws FileNotFoundException {
      Scanner input = new Scanner(System.in);
      intro(input);
      System.out.print("input file name? ");
      String inFileName = input.nextLine();
      Scanner reader = new Scanner(new File(inFileName));
      String name = "", data = "";
      System.out.print("output file name? ");
      String outFileName = input.nextLine();
      PrintStream output = new PrintStream(new File(outFileName));    
      while (reader.hasNextLine()) {
         name = reader.nextLine();
         data = reader.nextLine();
         int[] aAnswers = letterCounter(name, data, 'a');
         int[] bAnswers = letterCounter(name, data, 'b'); 
         int[] percentages = add(aAnswers, bAnswers);
         String personality = personalityType(percentages);   
         output.println(name + ": " + Arrays.toString(percentages) + " = " + personality);   
      }                                                                                                         
   }
   
   //This method prints out the intro of the program, explaining what it does.
   public static void intro(Scanner input) {
      System.out.println("This program processes a file of answers to the");
      System.out.println("Keirsey Temperament Sorter. It converts the");
      System.out.println("various A and B answers for each person into");
      System.out.println("a sequence of B-percentages and then into a");
      System.out.println("four-letter personality type.");
      System.out.println();
   }
   
   //This method of type int array takes in two integer arrays and uses them to
   //add all of the values counted for a and b together in their proper categories.
   //It then takes the percentage of b and returns an array with all of the percentages
   //of b for all of the categories.
   public static int[] add(int[] countA, int[] countB) {
      int[] percentages = new int[DIMENSIONS];
      for (int i = 0; i < DIMENSIONS; i++) {
         double percentage = (countA[i] + countB[i] * 1.0);
         int percent = (int) Math.round((countB[i] / percentage * 100));
         percentages[i] = percent;        
      } 
      return percentages;   
   }
   
   //This method takes in an integer array and uses the percentages of b to
   //determine the person's personality type for that category. It then returns 
   //a string with their full personality type.
   public static String personalityType(int[] percentages) {           
      String type = "";
      for (int i = 0; i < DIMENSIONS; i++) {
         if (percentages[i] > 50) {
            if (i == 0) {
               type = type + "I";
            } else if (i == 1) {
               type = type + "N";
            } else if (i == 2) {
               type = type + "F";
            } else {
               type = type + "P";
            }
         } else if (percentages[i] < 50) {
            if (i == 0) {
               type = type + "E";
            } else if (i == 1) {
               type = type + "S";
            } else if (i == 2) {
               type = type + "T";
            } else {
               type = type + "J";
            }
         } else if (percentages[i] == 50) {
            type = type + "X";
         }                  
      }
      return type;   
   }
   
   //This method takes in the name of the person who is taking the test, the line
   //of data for their answers, and the type of data we are counting for. It then
   //counts the amount of either a or b answers that it is given and puts them in 
   //their correct index of an array which is then returned to main.
   public static int[] letterCounter(String name, String data, char letter) {
      int[] letterCount = new int[DIMENSIONS];
      int count = 0;
      for (int i = 0; i < data.length(); i++) {
         count++;
         if (count > 7) { 
            count = 1;
         }
         data = data.toLowerCase();
         char choice = data.charAt(i);         
         if (choice == letter) {
            if (count == 1) {
               letterCount[0]++;
            } else if (count == 2 || count == 3) {
               letterCount[1]++;
            } else if (count == 4 || count == 5) {
               letterCount[2]++;
            } else if (count == 6 || count == 7) {
               letterCount[3]++;         
            }
         }     
      }
      return letterCount; 
   }       
}