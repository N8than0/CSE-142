//Nathan Gomez
//CSE 142
//TA: Noa Ferman
//2/23/2021

/*
This program will take in a name from the user and cross reference it with a 
text file to match it with the data in the text file. If the name matches with a 
name in the file, this program creates a chart and plots the name's rank in popularity
for a given number of decades.
*/
import java.util.*;
import java.io.*;
import java.awt.*;
public class Names {
   
   public static final int DECADES = 10, START = 1920, WIDTH = 70;
   
   //This main method determines whether the program should read from the 
   //first or the second file by checking the global constants, after that,
   //it will create a scanner for the file and run the methods to read that file
   //if the necessary requirements are met, and creates a drawing panel if they are.   
   public static void main(String[] args) throws FileNotFoundException {
      Scanner input = new Scanner(System.in);
      String file;
      if (DECADES == 14 && START == 1880) {
         file = "names.txt";
      } else {
         file = "names2.txt";
      }
      Scanner read = new Scanner(new File(file));
      intro();
      String wholeLine = choice(input, read);
      if (wholeLine == "not found") {
         System.out.println("name/sex combination not found");
      } else {   
         DrawingPanel draw = new DrawingPanel(WIDTH * DECADES, 550);
         Graphics brush = draw.getGraphics();
         outline(brush);
         drawData(wholeLine, brush);   
      }
   }
   
   //This method displays the intro message of the program explaining
   //what it does.
   public static void intro() {
      System.out.println("This program allows you to search through the");
      System.out.println("data from the Social Security Administration");
      System.out.println("to see how popular a particular name has been");
      System.out.println("since " + START + ".");
      System.out.println(); 
   }
   
   //This method takes in input and reader scanners to take in user input and read
   //the names files. It takes in a name and sees if that name exists in the name database.
   //If the name exists, it takes that whole line from the names file and returns it in a 
   //String.
   public static String choice(Scanner input, Scanner read) throws FileNotFoundException {
      System.out.print("name? ");
      String nameOne = input.nextLine();
      System.out.print("sex (M or F)? ");
      String genderOne = input.nextLine();
      nameOne = nameOne + " " + genderOne; 
      String nameInFile = "";
      String fullLine = "not found";     
      while (read.hasNextLine()) {
         String lines = read.nextLine();
         Scanner token = new Scanner(lines);
         nameInFile = token.next();
         String gender = token.next();
         nameInFile = nameInFile + " " + gender;
         if (nameOne.equalsIgnoreCase(nameInFile)) {            
            fullLine = lines;
         } 
      }
      return fullLine;    
   }
   
   //This method creates the outline for the drawing panel by taking in a graphics object
   //to draw in the drawing panel. 
   public static void outline(Graphics g) {
      g.setColor(Color.BLACK);
      g.drawLine(0, 25, WIDTH * DECADES, 25);
      g.drawLine(0, 525, WIDTH * DECADES, 525); 
      int year = START;
      for (int i = 0; i <= DECADES; i++) {
         g.setColor(Color.BLACK);
         g.drawLine(WIDTH * i, 0, WIDTH * i, 550);
         g.drawString(year + "", WIDTH * i, 550);
         year += 10;
      }          
   }
   
   //This method takes in the line from the names file and the graphics object. A new 
   //scanner is created to read the line token by token. That data is used to plot the graph
   //with the name, gender and rank included to their corresponding years.
   public static void drawData(String line, Graphics g) {
      Scanner reader = new Scanner(line);
      String name = reader.next();
      String gender = reader.next();
      String nameInFile = name + " " + gender;
      int xCoordinate = 0;
      int yCoordinate = 0;
      int rank = 0;
      int previous = 0;
      g.setColor(Color.RED);     
      for (int i = 0; i < DECADES; i++) {        
         previous = yCoordinate;
         rank = reader.nextInt();      
         if (rank > 0) {
            yCoordinate = rank / 2 + 25;
         } else {
            yCoordinate = 525; 
         }   
         g.drawString(nameInFile + " " + rank, WIDTH * i, yCoordinate);
         g.drawLine(xCoordinate - WIDTH, previous, xCoordinate, yCoordinate);
         xCoordinate += WIDTH;
      }                     
   }  
}

   