// Ali Cole Part B Java
// Lesson 07: HW due 10/16/24

import java.util.Scanner;

public class PartB {

    public enum DayOfWeek {SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY}
    public enum CustomerType {CHILD, ADULT, SENIOR}
    public static void main(String[] args) {
        // Define the variables
        Scanner in = new Scanner(System.in);
        double discount = 0.0;

        System.out.print("Enter day of the week (0 = SUN, ..., 6 = SAT): ");
            int dayInt = in.nextInt();

        System.out.print("How old is the customer? ");
            int age = in.nextInt();

        System.out.print("What is the cost of the meal? ");
            double initCost = in.nextDouble();
       
        DayOfWeek today;
        CustomerType customer;
    
        switch (dayInt) {
            case 0: 
                today = DayOfWeek.SUNDAY;
                break;
            case 1:
                today = DayOfWeek.MONDAY;
                break;
            case 2:
                today = DayOfWeek.TUESDAY;
                break;
            case 3:
                today = DayOfWeek.WEDNESDAY;
                break;
            case 4:
                today = DayOfWeek.THURSDAY;
                break;
            case 5: 
                today = DayOfWeek.FRIDAY;
                break;
            case 6:
                today = DayOfWeek.SATURDAY;
            default:
                throw new AssertionError();
        }

        if (age < 13) {
            customer = CustomerType.CHILD;
        } else if (age < 50) {
            customer = CustomerType.ADULT;
        } else {
            customer = CustomerType.SENIOR;
        }

        // Define discounts based on date and age
        if (today != DayOfWeek.MONDAY) {
            // If the day is not Monday, run this code
            System.out.println("It is not Monday");
            if (customer == CustomerType.SENIOR) {
                System.out.println("As a senior, you have received a 7.5% discount on your meal today!");
                discount = 0.075;
            } else if (customer == CustomerType.CHILD) {
                System.out.println("As a child, you have received a 5% discount on your meal today!");
                discount = 0.05;
            }
    
        } else if (today == DayOfWeek.MONDAY) {
            // If the day is Monday, run this code
            System.out.println("It is Monday");
            if (customer == CustomerType.SENIOR) {
                System.out.println("As a senior, you have received a 15% discount on your meal today!");
                discount = 0.15;
            } else if (customer == CustomerType.CHILD) {
                System.out.println("As a child, you have received a 7.5% discount on your meal today!");
                discount = 0.075;
            } else if (customer == CustomerType.ADULT) {
                System.out.println("As an adult, you have received a 5% discount on your meal today!");
                discount = 0.05;
            }

        } else {
            System.out.print("There seems to be an issue. Please try again");
        }

        double finalCost = initCost - initCost*discount;
        System.out.println("Your total cost for today will be $" + finalCost);
    }
}