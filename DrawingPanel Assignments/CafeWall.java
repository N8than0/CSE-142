//Nathan Gomez
//CSE 142 
//TA: Noa Ferman
//1/26/2021

//This program will create a drawing of the cafe wall illusion using parameters
//and drawing panel
import java.awt.*;
public class CafeWall {

   public static final int MORTAR = 2;
   /*This method will run the row and grid methods with different parameters to
   determine the positioning, size, amount and offset.*/
   public static void main(String[] args) {
      DrawingPanel p = new DrawingPanel(650, 400);
      p.setBackground(Color.GRAY);
      Graphics brush = p.getGraphics();
      oneRow(brush, 0, 0, 20, 4);
      oneRow(brush, 50, 70, 30, 5);
      moreRows(brush, 10, 150, 25, 4, 0);
      moreRows(brush, 250, 200, 25, 3, 10);
      moreRows(brush, 425, 180, 20, 5, 10);
      moreRows(brush, 400, 20, 35, 2, 35);    
   }
   
   /*This method will use parameters for the x and y coordinates, the size of the boxes,
   and the amount of pairs needed. These specific parameters were used so that the method
   can be called in main with different dimensions and placements.*/
   public static void oneRow(Graphics brush, int x, int y, int size, int pairs) { 
      for (int i = 0; i < pairs; i++) {
         brush.setColor(Color.BLACK);
         brush.fillRect(x + size * i * 2, y, size, size);
         brush.setColor(Color.BLUE);
         brush.drawLine(x + size * i * 2, y, x + size * i * 2 + size, y + size);
         brush.drawLine(x + size * i * 2, y + size, x + i * 2 * size + size, y);  
         brush.setColor(Color.WHITE);
         brush.fillRect(x + size * i * 2 + size, y, size, size);
      }  
   }
  
   /*This method builds upon the original row method by calling it here in a for loop.
   The parameters in this method are the same as oneRow except for offSet so that the grids 
   can get the optical illusion effect every other row.*/
   public static void moreRows(Graphics brush, int x, int y, int size,
                               int pairs, int offSet) {
      for (int i = 0; i < pairs * 2; i++) {
         oneRow(brush, x + offSet * (i % 2), y + i * size + MORTAR * i, size, pairs);
      }
   }
}