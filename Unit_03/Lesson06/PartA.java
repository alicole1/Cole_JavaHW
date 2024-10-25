// Ali Cole
// Lesson 06 Part A
// Cougar baking company

import java.util.Scanner;

public class PartA {
    public static void main(String[] args) {
        double initCost = 10.0;
        
        Scanner in = new Scanner(System.in);

        System.out.print("How many pies would you like? ");
        int pieNumber = in.nextInt();

        if (pieNumber >= 3) {
            System.out.println("You qualify for our discount! 10% off your order");
            System.out.println("Your total is $" + (initCost*pieNumber*0.9));
        } else {
            System.out.println("Your total is $" + (initCost*pieNumber));
        }

        in.close();
    }
}
