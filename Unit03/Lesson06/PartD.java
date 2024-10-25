// Ali Cole
// Lesson 06 Part D
// Cougar baking company


import java.util.Scanner;

public class PartD {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double price = 0.99;

        System.out.print("How many cookies would you like? ");
        double number = in.nextDouble();

        if (number > 24) {
            System.out.println("You qualify for our discount! 15% off your order");
            System.out.printf("Your total is $%.2f %n", (price*number*0.85));
        } else if (number > 12) {
            System.out.println("You qualify for our discount! 5% off your order");
            System.out.printf("Your total is $%.2f %n", (price*number*0.95));
        } else if (number > 6) {
            System.out.println("You qualify for our discount! 2.5% off your order");
            System.out.printf("Your total is $%.2f %n", (price*number*0.975));
        } else {
            System.out.printf("Your total is $%.2f %n" + (price*number));
        }
    }
}
