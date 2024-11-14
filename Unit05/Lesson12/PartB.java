// Ali Cole AT Java
// Lesson 12: Variable Scope
// Part B

import java.util.Scanner;

public class PartB {
    static double smallest (double x, double y, double z) {
            double smallest;
            if (x <= y) {
                smallest = x;
            } else {
                smallest = y;
            }
    
            if (smallest >= z) {
                smallest = z;
            }
    
            return smallest;
        }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter first double: ");
        double x = scan.nextDouble();
        System.out.print("Enter second double: ");            
        double y = scan.nextDouble();
        System.out.print("Enter third double: ");
        double z = scan.nextDouble();
        scan.close();
    
        double smallest = smallest(x, y, z);
        System.out.println("The smallest out of your doubles is " + smallest);
    }
}
