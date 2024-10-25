// Ali Cole
// Box Information Homework "Part C"

import java.util.Scanner;

public class PartC {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in); // Set up new scanner

    // Collect information from user
        System.out.print("Length: ");
        double length = in.nextDouble();
        System.out.print("Width: ");
        double width = in.nextDouble();
        System.out.print("Height: ");
        double height = in.nextDouble();
    
    // Calculate information
        double surfaceArea = 2 * (width*length + height*length + height*width);
        System.out.printf("Surface area is %10.2f%n", surfaceArea);
        double volume = length * width * height;
        System.out.printf("Volume is %16.2f%n", volume);
    }
}
