import java.util.*;

public class Rock {

   public static void main(String[] args) {
      Scanner s = new Scanner(System.in);
      Random r = new Random();
      int comwins = 0;
      int humwins = 0;
      do {
         String wins = mainGame(s, r);
         if (wins.equals("YOU WIN")) {
            humwins++;
         } else if (wins.equals("YOU LOSE")) {
            comwins++;
         }
      
      } while (comwins < 3 || humwins < 3);
   
   
   }
   
   public static String mainGame(Scanner s, Random myRand) {
      int comwins = 0; // Calculate how many wins
      int humwins = 0;
      int com = myRand.nextInt(3); // Generate random computer choice 
      System.out.println("Paper = 0 , Rock = 1, or Sciccosrs = 2 ?");
      int hum = s.nextInt(); // Set users input to variable
         if (hum == 0) {
            if(com == 1) {
               System.out.println("You chose paper, computer chose rock. YOU WIN!");
               humwins++;
            } else if (com == 2) {
               System.out.println("You chose paper, computer choice scissors. YOU LOSE:(");
               comwins++;
            }
         } else if (hum == 1) {                 
            if (com == 2) {
               System.out.println("You chose rock, computer choice scissors. YOU WIN!");
               humwins++;
            } else if (com == 0) {
               System.out.println("You chose rock, computer choise paper. YOU LOSE :(");
               comwins++;
            }
             
          } else if (hum == 2) {
               if (com == 0) {
                  System.out.println("You chose scissors, computer choice paper. YOU WIN!");
                  humwins++;
               } else if (com == 1) {
                  System.out.println("You chose scissors, computer choice rock. YOU LOSE :(");
                  comwins++;
               }
          } else if (hum == (com)) {
               System.out.println("It's a tie!");
          }
     
      if (humwins > comwins) {
         return "YOU WIN";
      } else {
         return "YOU LOSE";
      }
                
   } 
}