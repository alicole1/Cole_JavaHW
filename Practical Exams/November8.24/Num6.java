import java.util.Scanner;

public class Num6 {
    public static void main(String[] args) {
        // Declare scanner object.
        Scanner scan = new Scanner(System.in);

        // Initialize common variables.
        int placeholderInt = 0; 
            // Placeholder serves as a variable to hold whatever number we are swapping. 
            // Without placeholder, when we try to swap two numbers, we lose one of the numbers in the process. Thanks placeholder!

        // Collect user info.
        System.out.print("First integer: ");
        int largestInt = scan.nextInt();
        System.out.print("Second integer: ");
        int middleInt = scan.nextInt();
        System.out.print("Third integer: ");
        int smallestInt = scan.nextInt();

        // Sort integers.
        // TROUBLESHOOTING System.out.println("Original order of numbers: " + largestInt + " " + middleInt + " " + smallestInt);

        // Sort first and second number.
        if (largestInt < middleInt) {
            placeholderInt = middleInt;
            middleInt = largestInt;
            largestInt = placeholderInt;
        }
        
        // TROUBLESHOOTING System.out.println("First num should be larger than second: " + largestInt + " " + middleInt + " " + smallestInt);

        // Sort first and third number.
        if (largestInt < smallestInt) {
            placeholderInt = smallestInt;
            smallestInt = largestInt;
            largestInt = placeholderInt;
        }

        // TROUBLESHOOTING System.out.println("First num should be larger than third: " + largestInt + " " + middleInt + " " + smallestInt);

        // Sort second and third number.
        if (middleInt < smallestInt) {
            placeholderInt = smallestInt;
            smallestInt = middleInt;
            middleInt = placeholderInt;
        }

        // Give information to user.
        System.out.println("All should be in correct order: " + largestInt + " " + middleInt + " " + smallestInt);

        // Close scanner.
        scan.close();
    }
}
