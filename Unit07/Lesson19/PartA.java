// Ali Cole
// Lesson 19 - Reading and Writing Text Files
// Part A

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PartA {

    /** METHOD: Collects and fills an array. */
    public static void getTemps(String fileName, ArrayList<Integer> temps) throws FileNotFoundException{
        File inputFile = new File(fileName);
        Scanner scan = new Scanner(inputFile);
        while (scan.hasNext()) { // Will go until there is nothing left to scan.
                temps.add(scan.nextInt());
        }
        // We do not need to return the array, as it is passed by reference.
        scan.close();
    }

    /** METHOD: Finds lowest of numbers in an array. */
    public static int findLowest(ArrayList<Integer> temps) {
        int lowest = temps.get(0);
        for (int i = 0; i < temps.size(); i++) {
            if (temps.get(i) < lowest) {
                lowest = temps.get(i);
            }
        }
        return lowest;
    }

    public static void main(String[] args) throws FileNotFoundException {
        String fileName = "temps.txt"; // Input name of file.
        ArrayList<Integer> temps = new ArrayList<Integer>(); // Creates new ArrayList.

        // Fill array
        getTemps(fileName, temps);

        int lowestVal = findLowest(temps);

        // Return to user.
        System.out.printf("%nTemperatures: %n------------------ %n");
        for (int i = 0; i < temps.size(); i++) {
            System.out.printf("%3d", temps.get(i));
            if (temps.get(i) == lowestVal) {
                System.out.println(" <= lowest");
            } else {
                System.out.printf("%n");
            }
        }

    }
}