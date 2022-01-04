//Nathan Gomez
//CSE 142 
//TA: Noa Ferman
//1/14/2021

//This program will use for loops to create ascii art of a rocket ship and
//scale to different sizes
public class RocketShip {
   public static final int SIZE = 6;
   
   //This main method runs all of the methods that build up the rocket ship.
   public static void main(String[] args) {
      cone();
      line();
      topHalf();
      bottomHalf();
      line();
      bottomHalf();
      topHalf();
      line();
      cone();  
   }
   
   //This method uses for loops to create the cone figure seen at the top 
   //and bottom of the figure.
   public static void cone() {
      for (int line = 1; line <= SIZE * 2 - 1; line++) {
         for (int spaces = 1; spaces <= -line + SIZE * 2; spaces++) {
            System.out.print(" ");
         }
         for (int slash = 1; slash <= line; slash++) {
            System.out.print("/");
         }
         System.out.print("**");
         for (int backSlash = 1; backSlash <= line; backSlash++) {
            System.out.print("\\");
         }
         System.out.println();
      }
   }
   
   //This method creates a line that divides all of the other patterns
   //on the rocket ship
   public static void line() {
      System.out.print("+");
      for (int plusEquals = 1; plusEquals <= SIZE * 2; plusEquals++) {
         System.out.print("=*");
      }
      System.out.println("+");
   }
   
   //This method creates the top half of the shapes seen in the middle.
   public static void topHalf() {
      for (int line = 1; line <= SIZE; line++) {
         System.out.print("|");
         for (int frontDots = 1; frontDots <= -line + SIZE; frontDots++) {
            System.out.print(".");
         }
         for (int arrow = 1; arrow <= line; arrow++) {
            System.out.print("/\\");
         }
         for (int midDots = 1; midDots <= -2 * line + SIZE * 2; midDots++) {
            System.out.print(".");
         }
         for (int arrowTwo = 1; arrowTwo <= line; arrowTwo++) {
            System.out.print("/\\");
         }
         for (int backDots = 1; backDots <= -line + SIZE; backDots++) {
            System.out.print(".");
         }
         System.out.println("|");
      }
   }
   
   //This method creates the bottom half of the shape seen in the middle.
   public static void bottomHalf() {
      for (int line = 1; line <= SIZE; line++) {
         System.out.print("|");
         for (int frontDots = 1; frontDots <= line - 1; frontDots++) {
            System.out.print(".");
         }
         for (int arrow = 1; arrow <= -line + SIZE + 1; arrow++) {
            System.out.print("\\/");
         }
         for (int midDots = 1; midDots <= 2 * line - 2; midDots++) {
            System.out.print(".");
         }
         for (int arrowTwo = 1; arrowTwo <= -line + SIZE + 1; arrowTwo++) {
            System.out.print("\\/");
         }
         for (int backDots = 1; backDots <= line - 1; backDots++) {
            System.out.print(".");
         }
         System.out.println("|");
      }
   }
} 