//Nathan Gomez
//1/8/2020
//CSE 142
//TA: Noa Ferman
//Take-Home Assessment #1

//This program will display the lyrics of a song.
public class Song {
   
   //This method will define the phrase about swallowing the fly.
   public static void flyRepeat() {
      System.out.println("I don't know why she swallowed that fly,");
      System.out.println("Perhaps she'll die.");
   }
   
   //This method will define the phrase, about the spider.
   public static void spiderFly() {
      System.out.println("She swallowed the spider to catch the fly,");
   }
   
   //This method helps reduce redundancy by combining some methods together
   public static void spiderFlyRepeat() {
      spiderFly();
      flyRepeat();
   }
   
   //This method will define the phrase about the bird
   public static void birdSpider() {
      System.out.println("She swallowed the bird to catch the spider,");
   }
   
   //This method will define the phrase about swallowing the cat.
   public static void catBird() {
      System.out.println("She swallowed the cat to catch the bird,");
   }
   
   //This method helps reduce redundancy by combining some methods together
   public static void catToFly() {
      catBird();
      birdSpider();
      spiderFlyRepeat();
   }
   
   //This method helps reduce redundancy by combining some methods together
   public static void mouseToFly() {
      mouseDog();
      dogCat();
      catToFly();
   }
   
   public static void dogCat() { //This method will define the phrase about swallowing the dog.
      System.out.println("She swallowed the dog to catch the cat,");
   }
   
   //This method will define the phrase about swallowing the mouse.
   public static void mouseDog() {
      System.out.println("She swallowed the mouse to catch the dog,");
   }
   
   //This method will give the output of the first verse.
   public static void verseOne() {
      System.out.println("There was an old woman who swallowed a fly.");
      flyRepeat();
      System.out.println();
      
   }
   
   //This method will give the output of the second verse.
   public static void verseTwo() {
      System.out.println("There was an old woman who swallowed a spider,");
      System.out.println("That wriggled and iggled and jiggled inside her.");
      spiderFlyRepeat();
      System.out.println();
      
   }
   
   //This method will give the output of the third verse.
   public static void verseThree() {
      System.out.println("There was an old woman who swallowed a bird,");
      System.out.println("How absurd to swallow a bird.");
      birdSpider();
      spiderFlyRepeat();
      System.out.println();
      
   }
   
   //This method will give theoutput of the fourth verse.
   public static void verseFour() {
      System.out.println("There was an old woman who swallowed a cat,");
      System.out.println("Imagine that to swallow a cat.");
      catToFly();
      System.out.println();
      
   }
   
   //This method will give theoutput of the fifth verse.
   public static void verseFive() {
      System.out.println("There was an old woman who swallowed a dog,");
      System.out.println("What a hog to swallow a dog.");
      dogCat();
      catToFly();
      System.out.println();
      
   }
   
   //This method will give theoutput of the sixth verse.
   public static void verseSix() {
      System.out.println("There was an old woman who swallowed a mouse.");
      System.out.println("What a spouse to swallow a mouse.");
      mouseToFly();
      System.out.println();
      
   }
   
   //This method will output the last two lines of the song.
   public static void endSong() {
      System.out.println("There was an old woman who swallowed a horse,");
      System.out.println("She died of course.");
      
   }
   
   //This method will call all of the verses.
   public static void main(String[] args){
      verseOne();
      verseTwo();
      verseThree();
      verseFour();
      verseFive();
      verseSix();
      endSong();
   }
}