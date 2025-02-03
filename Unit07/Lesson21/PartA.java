// Ali Cole
// Lesson 21 - Processing Files
// Part A

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PartA {
    public static void main(String[] args) throws FileNotFoundException {
        // Setup to read file.
        File inputFile = new File("Top5Unemployment.txt");
        Scanner in = new Scanner(inputFile);

        System.out.println("---------------------------------------------------------------");
        System.out.println("                   Top 5 Unemployment Rates");
        System.out.println("---------------------------------------------------------------");

        // Scan file line by line.
        while (in.hasNextLine()) {
            String line = in.nextLine();
            Scanner lineScanner = new Scanner(line);
            lineScanner.useDelimiter("[,\n]+");
            String name = lineScanner.next().trim(); // grabs name of country.
            String nextWord = lineScanner.next().trim();
            double percentage = Double.valueOf(nextWord); // grabs unemployment rate.
            nextWord = lineScanner.next().trim();
            int rank = Integer.valueOf(nextWord); // grabs the rank.
            String region = lineScanner.next().trim(); // grabs the continent.

            System.out.printf("Ranked #%3d: %-16s | %6.2f%%  | %-20s%n",
                    rank, name, percentage, region);
        }

    }
}