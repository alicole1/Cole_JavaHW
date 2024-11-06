import java.util.Scanner; // Import scanner class.

public class PartC {
    // Main method. Prompts user for radius, responds with volume of a sphere with said radius.
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); // Make new scanner object.
        System.out.print("Enter the radius of your sphere (in m): "); // Print prompt for radius to terminal.
        double radius = scan.nextDouble(); // Collect user resposne. Store as a double.
        scan.close(); // Close scanner, we dont need it anymore.
        double volume = volume(radius); // Run method "volume()" with our variable radius as an input. Store output as a double.
        System.out.printf("The volume for your sphere is (in m^3): %.4f %n", volume); // Print formatted volume to terminal. (4 digits after .).
    }

    // Method to find volume of a sphere. Takes a double (radius) and returns a double (volume).
    public static double volume(double radius) {
        double volume = Math.PI*Math.pow(radius,3)*1.33333333; // Find volume with equation.
        return volume; // Return calculated volume.
    }
}
