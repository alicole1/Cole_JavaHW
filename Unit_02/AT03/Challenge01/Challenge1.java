// Ali Cole
// AT 03 Challenge Problems
// Challenge Problem 1

import java.util.Scanner;

public class Challenge1 {
    public static void main(String[] args) {

        // Collect price from user
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a price in dollar and cents format. (for example: 21.74): ");
        String price = in.nextLine();

        // Find location of the period (the break between dollar and cent values)
        int periodLocation = price.indexOf(".");

        // Find substring left of period (dollar amount) and right of the period (cent amount)
        String dollarAmount = price.substring(0, periodLocation);
        String centAmount = price.substring(periodLocation+1);

        // Create boolean for if cent value is one digit
        boolean isCentOneDigit = price.substring(periodLocation+1).equals(price.substring(periodLocation+1, periodLocation+2));

        // Account for if user only input one digit after period or more than two digits after period
        if (isCentOneDigit == true) {
            // Only one digit after period
            centAmount = price.substring(periodLocation+1) + "0";
            System.out.println(centAmount);    
        } else {
            // More than one digit after period 
            // Create boolean for if cent value is two digits
            boolean isCentTwoDigits = price.substring(periodLocation+1).equals(price.substring(periodLocation+1, periodLocation+3));
            if (isCentTwoDigits == false) {
                // More than two digits after period
                System.err.println("Please input at most 2 digits after period");
                return;
            }
        }

        // Return information to user
        System.out.println("The price is " + dollarAmount + " dollars and " + centAmount + " cents!");
    }
}
