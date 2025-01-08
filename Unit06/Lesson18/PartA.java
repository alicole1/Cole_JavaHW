// Ali Cole
// Lesson 18 - Array Lists
// Part A

import java.util.ArrayList;
import java.util.Scanner;

public class PartA {

    // METHOD: Collects and fills an array.
    public static void getNames(Scanner scanner, ArrayList<String> names) {

        while (true) { 
            System.out.print("Enter a name or '#' to quit: ");
            if (scanner.hasNext("#")) { // Quits if user enters #.
                scanner.nextLine(); // "uses up" input.
                break;
            } else if (scanner.hasNextLine()) { // Collects names.
                names.add(scanner.nextLine());
            } else { // If user inputs something else, we don't want to accept.
                scanner.nextLine(); // "uses up" input.
                System.err.println("Invalid Input!");
            }
        }
        // We do not need to return the array, as it is passed by reference.
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> names = new ArrayList<String>(); // Creates new array to be filled.
        getNames(scanner, names); // Calls method to fill array.

        /*
         * Display names.
         */
        System.out.printf("%nNames: %n------------------ %n");
        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i));
        }
    }
}
