//Nathan Gomez
//CSE 142
//TA: Noa Ferman
//2/3/2021
//This program will choose a pseudorandom number and prompt you to guess it.
//It will save your scores and tell you your stats at the end.
import java.util.*;

public class Guess {
   
   public static final int MAX_VALUE = 100;
   
   //This main method carries the loop of the game and saves values of different
   //aspects of the game into variables to be used later.
   public static void main(String[] args) {
      Random rand = new Random();
      Scanner input = new Scanner(System.in);
      int totalGames = 0, totalGuesses = 0, bestGame = 1000000;
      boolean runAgain = true;
      intro();
      while (runAgain) {
         int numGuess = mainGame(rand,input);
         runAgain = numGuesses(numGuess, input);
         totalGuesses += numGuess;
         if (numGuess < bestGame) {
            bestGame = numGuess;
         }
         totalGames++;
         System.out.println();
      }
      statsForGame(totalGames, totalGuesses, bestGame);
   }
   
   //This method displays the intro of the game, which is the description.
   public static void intro() {
      System.out.println("This program allows you to play a guessing game.");
      System.out.println("I will think of a number between 1 and");
      System.out.println("100 and will allow you to guess until");
      System.out.println("you get it. For each guess, I will tell you");
      System.out.println("whether the right answer is higher or lower");
      System.out.println("than your guess.");
      System.out.println();
   }
   
   //This method plays the game and takes in the random object, the scanner object,
   //an integer in order for the game to work effectively. Returns the value of the guesses
   //per game
   public static int mainGame(Random rand, Scanner input) {
      int guessPerGame = 0;
      int ranNum = rand.nextInt((MAX_VALUE)+1);
      int userIn = 0;
      System.out.println("I'm thinking of a number between 1 and " + MAX_VALUE + "...");
      while (userIn != ranNum) {
         System.out.print("Your guess? ");
         userIn = input.nextInt();
         guessPerGame++;
         if (userIn < ranNum) {
            System.out.println("It's higher.");
         } else if (userIn > ranNum) {
            System.out.println("It's lower.");
         }
      }
      return guessPerGame;
   }
   
   //This method displays how many tries it took you to guess the right number.
   //It takes in an integer for the amount of guesses and a scanner for the user
   //input and returns a boolean value for the game to be played again or not.
   public static boolean numGuesses(int guesses, Scanner input) {
      if (guesses == 1) {
         System.out.println("You got it right in " + guesses + " guess");
      } else {
         System.out.println("You got it right in " + guesses + " guesses");
      }
      System.out.print("Do you want to play again? ");
      String pick = input.next();
      String first = pick.substring(0,1);
      if (!first.equalsIgnoreCase("y")) {
         return false;
      }
      return true;
   }
   
   //This method takes in three integers and calculates the stats for the entire game based
   //on those integers.
   public static void statsForGame(int totalGames, int totalGuesses, int bestGame) {
      double totGuesses = rounded(totalGuesses);
      double guessesPerGame = rounded(totGuesses / totalGames);
      System.out.println("Overall results:");
      System.out.println("    Total games   = " + totalGames);
      System.out.println("    Total guesses = " + totalGuesses);
      System.out.println("    Guesses/game  = " + guessesPerGame);
      System.out.println("    Best game     = " + bestGame);
   }
   
   //This method takes in a double value and rounds it to one decimal place.
   public static double rounded(double round) {
      return Math.round(round * 10.0) / 10.0;
   } 
}