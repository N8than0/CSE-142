//Nathan Gomez
//CSE 142
//TA: Noa Ferman
//1/30/2021

//This program will take in 2 applicants SAT or ACT info 
//and gpa and give a total score based on that data
//to compare the two applicants. 

import java.util.*;

public class Admit {
   
   //This method controls the main flow of the program by running the applicant
   //method and the gpa method twice and storing those values in doubles to be used
   //in the results method.
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      intro();       
      double totalOne = appInfo(input, 1) + gpa(input);
      double totalTwo = appInfo(input, 2) + gpa(input);
      results(totalOne, totalTwo);   
   }
   
   //This method prints out the main message explaining what the program does.
   public static void intro() {
      System.out.println("This program compares two applicants to");
      System.out.println("determine which one seems like the stronger");
      System.out.println("applicant.  For each candidate I will need");
      System.out.println("either SAT or ACT scores plus a weighted GPA.");
      System.out.println();
   }
   
   //This method uses the scanner to have the user input the application
   //info and uses the int parameter to differentiate between student 1 and 2
   public static double appInfo(Scanner input, int run) {
      double testScores = 0;
      System.out.println("Information for applicant #" + run + ":");
      System.out.print("    do you have 1) SAT scores or 2) ACT scores? ");
      int satOrAct = input.nextInt();
      if (satOrAct == 1) {
         testScores = satScores(input);
      } else {
         testScores = actScores(input);
      }  
      return testScores;  
   }
   
   //This method prompts for the user to enter their SAT info and uses the 
   //scanner to make that possible.
   public static double satScores(Scanner input) {
      System.out.print("    SAT math? ");
      int math = input.nextInt();
      System.out.print("    SAT critical reading? ");
      int critReading = input.nextInt();
      System.out.print("    SAT writing? ");
      int writing = input.nextInt();
      double totalScore = (2.0 * math + critReading + writing) / 32.0;
      System.out.println("    exam score = " + round(totalScore));
      return totalScore;
   }
   
   //This method prompts the user to enter their ACT info and uses the
   //scanner to make that possible.
   public static double actScores(Scanner input) {
      System.out.print("    ACT English? ");
      int english = input.nextInt();
      System.out.print("    ACT math? ");
      int math = input.nextInt();
      System.out.print("    ACT reading? ");
      int reading = input.nextInt();
      System.out.print("    ACT science? ");
      int science = input.nextInt();
      double totalScore = (english + 2.0 * math + reading + science) / 1.8;
      System.out.println("    exam score = " + round(totalScore));
      return totalScore;
   }
   
   //This method takes in a double value and rounds it to one decimal place
   public static double round(double rounded) {
      return Math.round(rounded * 10.0) / 10.0;
   }
   
   //This method prompts the user to enter their gpas and transcript multiplier
   //and uses scanner in order to take in the user input.
   public static double gpa(Scanner input) {
      System.out.print("    overall GPA? ");
      double overGpa = input.nextDouble();
      System.out.print("    max GPA? ");
      double maxGpa = input.nextDouble();
      System.out.print("    Transcript Multiplier? ");
      double multiplier = input.nextDouble();
      double gpaScore = (overGpa / maxGpa) * 100 * multiplier;
      System.out.println("    GPA score = " + round(gpaScore));
      System.out.println(); 
      return gpaScore;
   }
   
   //This method takes in two double values and prints out which student is better
   //based on those double values at the end of the program.
   public static void results(double totalOne, double totalTwo) {
      System.out.println("First applicant overall score  = " + round(totalOne));
      System.out.println("Second applicant overall score = " + round(totalTwo));
      if (totalOne > totalTwo) {
         System.out.println("The first applicant seems to be better");
      } else if (totalTwo > totalOne) {
         System.out.println("The second applicant seems to be better");
      } else {
         System.out.println("The two applicants seem to be equal");
      }
   }      
}