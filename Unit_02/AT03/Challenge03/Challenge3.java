// Ali Cole
// AT 03 Challenge Problems
// Challenge Problem 3

import java.util.Scanner;

public class Challenge3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter an integer: ");
        int num = in.nextInt();

        for (int i = 2; i<num; i++) {
            if (num%i == 0) {
                int factor = num / i;
                System.out.println("At the very least, " + i + " and " + factor + " factor into " + num + ". Therefore, you do not have a prime number.");
                return;
            }
        }

        System.out.println("You have a prime number!");
    }
}
