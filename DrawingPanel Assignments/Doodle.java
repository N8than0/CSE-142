//Nathan Gomez
//CSE 142
//TA: Noa Ferman
//1/26/2021

//This program creates a fun drawing by using DrawingPanel.
import java.awt.*;
public class Doodle {
   
   //All of the code that creates the shape is in this main method.
   //I used lines, rectangels, and string to make my drawing. 
   public static void main(String[] args){
      DrawingPanel panel = new DrawingPanel(100,100);
      panel.setBackground(Color.BLUE);
      Graphics p = panel.getGraphics();
      p.setColor(Color.BLACK);
      p.drawString("N.G.", 0, 90);
      p.fillRect(25,25,50,50);
      p.setColor(Color.GRAY);
      p.fillRect(25,25,45,45);
      p.setColor(Color.BLACK); 
      p.fillRect(25,25,40,40);
      p.setColor(Color.GRAY);
      p.fillRect(25,25,35,35);
      p.setColor(Color.BLACK);
      p.drawLine(0,0,25,25);
      p.drawLine(75,75,100,100);
      p.setColor(Color.RED);
      p.fillOval(27, 27, 30, 30);    
    }
}