// Ali Cole
// AT 03 Challenge Problems
// Challenge Problem 2

import java.util.Scanner;

public class Challenge2 {
    public static void main(String[] args) {

        // Collect telephone number from user
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a ten digit telephone number (no spaces): ");

        // Split number into parts
        String phoneNumber = in.nextLine();
        String firstPart = phoneNumber.substring(0,3);
        String secondPart = phoneNumber.substring(3,6);
        String thirdPart = phoneNumber.substring(6);

        // Return formatted number to user
        System.out.println("(" + firstPart + ") " + secondPart + "-" +thirdPart);
    }
}
