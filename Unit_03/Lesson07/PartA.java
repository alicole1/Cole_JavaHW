// Ali Cole Part A Java
// Lesson 07: HW due 10/16/24

import java.util.Scanner;
public class PartA {
    public static void main(String[] args) {
        // Define the variables
        Scanner in = new Scanner(System.in);
        double discount = 0.0;
        System.out.print("Is today Monday? y for yes n for no: ");
        String day = in.nextLine().toUpperCase();
        System.out.print("How old is the customer? ");
        int age = in.nextInt();
        System.out.print("What is the cost of the meal? ");
        double initCost = in.nextDouble();
       

        // Define discounts based on date and age
        if (day.equals("N")) {
            // If the day is not Monday, run this code
            System.out.println("It is not Monday");
            if (age >= 50) {
                System.out.println("You have received a 7.5% discount on your meal today!");
                discount = 0.075;
            } else if (age < 13) {
                System.out.println("You have received a 5% discount on your meal today!");
                discount = 0.05;
            }
        } else if (day.equals("Y")) {
            // If the day is Monday, run this code
            System.out.println("It is  Monday");
            if (age >= 50) {
                System.out.println("You have received a 15% discount on your meal today!");
                discount = 0.15;
            } else if (age < 13) {
                System.out.println("You have received a 7.5% discount on your meal today!");
                discount = 0.075;
            } else {
                System.out.println("You have received a 5% discount on your meal today!");
                discount = 0.05;
            }
        } else {
            System.out.print("There seems to be an issue. Please enter either y or n");
        }

        double finalCost = initCost - initCost*discount;
        System.out.println("Your total cost for today will be" + finalCost);
    }
}
