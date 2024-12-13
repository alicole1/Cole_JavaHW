import java.util.Scanner;

public class PartB {
    public static void main(String[] args) {
        // Collects user information to create original array.
        final int LENGTH = 20; // Can be set to any int to change orig length of array.
        int[] values = new int[LENGTH];
        int currentSize = 0; // Tracks how much of the array we are actually using.
        Scanner scan = new Scanner(System.in);
        while(true) { 
            System.out.print("Enter an integer value or 'q' to quit: ");
            if ((scan.hasNextInt()) && (currentSize < values.length)){
                int inputInt = scan.nextInt();
                if ((0<=inputInt) && (inputInt<10)) {
                    values[currentSize] = inputInt;
                    currentSize++;                    
                } else {
                    // If the user inputs a number out of the 0-10 range, to meet the "single integer" specification, we want to let them know. 
                    // Also, we don't want to add their number to the array, or add this "round" to the total count thus far.
                    System.err.println("Oops! Please ensure your integer falls between 0 and 10 :)");
                }
            } else if (scan.hasNext("q") || scan.hasNext("Q")) {
                scan.next();
                break;
            } else {
                System.err.println("Oops! Cannot accept; array is at max volume. :(");
                scan.nextInt(); // As we scan again in this program, we want to make sure this number is still "used up".
                break;
            }
        }

        // Displays array to user with commas in between.
        for (int i = 0; i < currentSize; i++) {
            if (i == (currentSize-1)) {
                System.out.println(values[i]);
            } else {
                System.out.print(values[i] + ",");
            }
        }

        // Code to collect number of times target is hit.
        System.out.print("Enter a target integer value: ");
        int target = scan.nextInt();
        int targetCount = 0;

        for (int i = 0; i < currentSize; i++) {
            if (values[i] == target) {
                targetCount++;
            }
        }

        // Displays info to user.
        System.out.println("The value " + target + " occurs " + targetCount + " times in your original data set.");
    }
}
