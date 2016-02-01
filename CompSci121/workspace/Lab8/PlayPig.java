/**
 * PlayPig.java
 *
 * Play a game of Pig 
 *
 * @author cs121
 */

import java.util.Scanner;

public class PlayPig {
   
    /**
     * @param args unused
     */
    public static void main (String[] args)
    {
        Scanner scan = new Scanner(System.in);
        Pig pig = new Pig(scan);
        char again = 'y';

        while (again == 'y') {
            pig.play();
            System.out.print("Do you want to play again? (y) : ");
            again = scan.next().toLowerCase().charAt(0);
        }

        System.out.println("Thanks for playing!");
    }
}