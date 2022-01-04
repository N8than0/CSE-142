//Nathan Gomez
//CSE 142
//TA: Noa Ferman
//3/9/2021

//This class will define the actions and traits of the bear 
//critter.
import java.util.*;
import java.awt.*;

public class Bear extends Critter {
   
   private boolean polar;
   private int moves = 0;
   
   //This method states that the boolean taken in as a parameter
   //is the same as the one made into a private field to decide whether or
   //not polar is true or false
   public Bear(boolean polar) {
      this.polar = polar;      
   } 
   
   //This method defines the color of the bear as being white or
   //black depending on if it is polar or not.
   public Color getColor() {
      if (!polar) {      
         return Color.WHITE;
      } else {
         return Color.BLACK;
      }
   }
   
   //This method makes the bear be either a forward slash or backslash.
   //It is split into half and half.
   public String toString() {
      moves++;
      if (moves % 2 == 1) {
         return "/";
      } else {
         return "\\";
      }   
   }
   
   //This method defines the moves made by the bear, hop if no one is in front,
   //otherwise infect if the critter in front is of another type, and turn left 
   //on any other case.
   public Action getMove(CritterInfo info) {
      if (info.getFront() == Neighbor.EMPTY) {
         return Action.HOP;
      } else if (info.getFront() == Neighbor.OTHER) {
         return Action.INFECT;
      } else {
         return Action.LEFT;
      }       
   }
}