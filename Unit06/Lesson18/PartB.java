// Ali Cole
// Lesson 18 - Array Lists
// Part B

import java.util.ArrayList;
import java.util.Scanner;

public class PartB {

    // METHOD: Collects and fills an array.
    public static void getScores(Scanner scanner, ArrayList<Double> scores) {

        while (true) { 
            System.out.print("Enter a score or 'q' to quit: ");
            if (scanner.hasNext("q") || scanner.hasNext("Q")) { // Quits if user enters #.
                scanner.nextLine(); // "uses up" input.
                break;

            } else if (scanner.hasNextDouble()) { // Collects scores.
                scores.add(scanner.nextDouble());
            } else { // If user inputs something else, we don't want to accept.
                scanner.nextLine(); // "uses up" input.
                System.err.println("Invalid Input!");
            }
        }
        // We do not need to return the array, as it is passed by reference.
    }

    // METHOD: Finds Average of numbers in an array.
    public static double findAverage(ArrayList<Double> scores) {
        double total = 0;
        for (int i = 0; i < scores.size(); i++) {
            total = total + scores.get(i);
        }

        double average = total / (scores.size());
        return average;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> scores = new ArrayList<Double>(); // Creates new array to be filled.
        
        getScores(scanner, scores); // Calls method to fill array.
        double average = findAverage(scores); // Find average.

        // Return to user.
        System.out.printf("%nScores: %n------------------ %n");
        for (int i = 0; i < scores.size(); i++) {
            System.out.printf("%.2f %n", scores.get(i));
        }
        System.out.println("Average: " + average);
    }
}
