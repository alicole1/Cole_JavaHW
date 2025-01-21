// Ali Cole
// Lesson 22 - Handling Exceptions
// Part A

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PartA {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean errorCheck = false;
        while (errorCheck == false) {
            System.out.print("Enter a filename to read or the # symbol to quit: ");
            String input = scan.nextLine();
            try {
                if (input.equals("#")) {
                    System.out.println("Goodbye!");
                    errorCheck = true;
                    return;
                } else {
                    File inputFile = new File(input);
                    Scanner in = new Scanner(inputFile);
                    while (in.hasNext()) {
                        System.out.println(in.next());
                    }
                    errorCheck = true;
                    in.close();
                    return;
                }
            } catch (FileNotFoundException e) {
                System.err.println("We could not find that file! Please try again.");
            } finally {
                scan.close();
            }
        }
    }
}