// Ali Cole AT Java
// Lesson 09: Using Loops
// Part A

// Import Scanner class.
import java.util.Scanner;

public class PartA {
    public static void main(String[] args) {
        // Create new scanner object.
        Scanner scan = new Scanner(System.in);

        // Tell user how to use program.
        System.out.println("Calculate Test Average! Input scores below. Enter a negative number to quit entering data.");
        
        // Delcare all variables we will use.
        Double newScore = 0.0; // Newest score inputted.
        Double totalScore = 0.0; // All scores added together.
        int numOfScores = 0; // Num of times new score was added.
        Double average = 0.0; // Average of all scores.

        do {
            System.out.print("Enter score: ");
            newScore = scan.nextDouble();
            // Only add new socre to total if it's not the "breaking score"
            // (ei. -1 won't be counted).
            if (newScore >= 0) {
                totalScore = totalScore + newScore;
                numOfScores = numOfScores + 1;
            }
        } while (newScore >= 0); // Break loop if inputted score is less than 0.

        // Calculate average score.
        average = totalScore / numOfScores;

        // Return number of scores entered to user.
        if (numOfScores == 1) {
            System.out.println("You entered 1 score."); // Corrects grammar error of "You entered 1 scores."
        } else {
            System.out.println("You entered " + numOfScores + " scores.");
        }
        // Return average  score to user.
        System.out.printf("The average score is %.2f %n",average);
        scan.close();
    }
}