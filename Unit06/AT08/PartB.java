// Ali Cole
// AT08 - Using Packages
// Part B

import java.util.Scanner;
import org.derryfield.math.Geometry;

public class PartB {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Radius: ");
        double radius = scan.nextDouble();
        double volume = Geometry.calcVolSphere(radius);
        System.out.printf("Volume of sphere: %.4f%n", volume);
        double surfaceArea = Geometry.calcSurfSphere(radius);
        System.out.printf("Surface area of sphere: %.4f%n", surfaceArea);

    }
}
