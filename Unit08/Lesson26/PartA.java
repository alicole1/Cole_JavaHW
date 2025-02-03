// Ali Cole
// Lesson 26 - Static Variables and Methods
// Part A

import java.util.Scanner;

public class PartA {
    public static void main(String[] args) {
        // Constant static value: Math.PI
        Scanner in = new Scanner(System.in);
        System.out.print("Input radius: ");
        double radius = in.nextDouble();
        double circumference = Math.PI * (2 * radius);
        System.out.printf("Circumference for given radius: %.4f%n", circumference);

        // Static value: Math.max(a, b)
        System.out.print("Input double a: ");
        double a = in.nextDouble();
        System.out.print("Input double b: ");
        double b = in.nextDouble();
        double max = Math.max(a, b);
        System.out.println("Max of your two numbers: " + max);

    }
}