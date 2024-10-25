// Ali Cole AT Java
// Lesson 08 - Intro to Loops
// Part B

import java.util.Scanner;

public class PartB {
    public static void main(String[] args) {

        // Collect information from user and declare variables
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the APR (as a percentage, for example, 5.5): ");
        Double apr = in.nextDouble() / 100;
        int year = 0;
        System.out.print("Enter the balance: ");
        Double balance = in.nextDouble();

        // Create table to declare to user
        System.out.println("Year |        Int Earned ($)       |           Balance ($)        ");
        System.out.println("----------------------------------------------------------------------");
        for (int i = 0; i < 5; i++) {
            // First column: year
            year = year + 1;
            System.out.print("  " + year + "  |");

            // Second column: earned
            System.out.printf("%28.2f |", balance * apr);

            // Third column: balance
            System.out.printf("%32.2f %n", balance + balance * apr);
        }

    }
}
