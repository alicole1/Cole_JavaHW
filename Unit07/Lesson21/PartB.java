// Ali Cole
// Lesson 21 - Processing Files
// Part B

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PartB {
    public static void main(String[] args) throws FileNotFoundException {
        // Setup to read file.
        File inputFile = new File("sales_by_cat.txt");
        Scanner in = new Scanner(inputFile);

        while (in.hasNext()) {
            String line = in.nextLine();
            Scanner lineScanner = new Scanner(line);
            lineScanner.useDelimiter("[, \n]+");
            String dept = lineScanner.next();
            String manager = lineScanner.next();
            double expense;

            if (lineScanner.hasNextDouble()) {
                expense = lineScanner.nextDouble();
            } else {
                // skip over the "n/a"
                lineScanner.next();
                expense = 0.0;
            }
            System.out.printf("%-17s | %-10s| $%10.2f%n", dept, manager, expense);
        }
    }
}
