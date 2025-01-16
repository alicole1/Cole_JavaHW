// Ali Cole
// Lesson 18 - Array Lists
// Part C

import java.util.ArrayList;
import java.util.Scanner;

public class PartC {

    // METHOD: Collects and fills an array.
    public static void getTemps(Scanner scanner, ArrayList<Double> temps) {

        while (true) { 
            System.out.print("Enter a temperature or 'q' to quit: ");
            if (scanner.hasNext("q") || scanner.hasNext("Q")) { // Quits if user enters q.
                scanner.nextLine(); // "uses up" input.
                break;

            } else if (scanner.hasNextDouble()) { // Collects temperatures.
                temps.add(scanner.nextDouble());
            } else { // If user inputs something else, we don't want to accept.
                scanner.nextLine(); // "uses up" input.
                System.err.println("Invalid Input!");
            }
        }
        // We do not need to return the array, as it is passed by reference.
    }

    // METHOD: Finds lowest of numbers in an array.
    public static double findLowest(ArrayList<Double> temps) {
        double lowest = temps.get(0);
        for (int i = 0; i < temps.size(); i++) {
            if (temps.get(i) < lowest) {
                lowest = temps.get(i);
            }
        }

        return lowest;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> temps = new ArrayList<Double>(); // Creates new array to be filled.
        
        getTemps(scanner, temps); // Calls method to fill array.
        double lowestNum = findLowest(temps); // Find average.

        // Return to user.
        System.out.printf("%nTemperatures: %n------------------ %n");
        for (int i = 0; i < temps.size(); i++) {
            System.out.printf("%.2f", temps.get(i));
            if (Math.abs(temps.get(i)-lowestNum) <= 0.00000001) {
                System.out.println(" <= lowest");
            } else {
                System.out.printf("%n");
            }
        }
    }
}
