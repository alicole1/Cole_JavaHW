// Ali Cole AT Java
// Lesson 09: Using Loops
// Part B

// Import Scanner class.
import java.util.Scanner;

public class PartB {
    public static void main(String[] args) {
        // Create new scanner object.
        Scanner scan = new Scanner(System.in);

        // Collect phrase from user; store as a string.
        System.out.print("Enter your phrase here: ");
        String phrase = scan.nextLine();

        // Declare our variables.
        char currentChar = 'a'; // Character var for the current letter.
        int numOfE = 0; // Integer var as a "counter" for num of times current letter = E.

        // Run loop through each character in the phrase.
        for (int i=0; i<phrase.length(); i++) {
            currentChar = phrase.charAt(i);
            currentChar = Character.toUpperCase(currentChar); // Turn character uppercase so that both cases 'E' and 'e' are accounted for.
            if (currentChar == 'E') {
                // If the current character is E, add one to our counter
                numOfE = numOfE + 1;
            }
        }
        
        // Return phrase and number of times "e" occured to user.
        if (numOfE == 1) {
            // Account for silly grammatical error with plural words.
            System.out.println("Your phrase: '" + phrase + "' contained the letter e 1 time.");
        } else {
            System.out.println("Your phrase: '" + phrase + "' contained the letter e " + numOfE + " times.");
        }
        scan.close();
    }
}
