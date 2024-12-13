import java.util.Arrays;
import java.util.Scanner;

public class PartB {
    
    // METHOD: Collects and fills an array.
    public static int getTestScores(Scanner scanner, double[] array) {
        double[] testScores = array;
        int length = 0;

        while (true) { 
            // If we exceed total length of array, we want to stop collecting scores.
            if (length >= testScores.length) {
                System.err.println("Thanks! Sorry, now we caannot accept more scores; array is at max volume. :(");
                scanner.nextLine();
                break;
            }

            System.out.print("Enter a test score or 'q' to quit: ");
            
            if (scanner.hasNextDouble()) { // Collects test scores.
                testScores[length] = scanner.nextDouble();
                length++; // Now we're using one more "space," so add one more to total used length.
            } else if (scanner.hasNext("q") || scanner.hasNext("Q")) { // Quits if user enters q or Q.
                scanner.nextLine(); // "uses up" input.
                scanner.nextLine(); // "uses up" input.
                break;
            } else { // If user inputs something else, we don't want to accept.
                scanner.nextLine(); // "uses up" input.
                scanner.nextLine(); // "uses up" input.
                System.err.println("Invalid Input!");
            }
        }
        return length; // Sends total used length back to user.
        // We do not need to return the array, as it is passed by reference.
    }
    
    public static double average(double... values) {
        int totalNums = 0;
        double total = 0;
        for (int i = 0; i < values.length; i++) {
            total = total+values[i];
            totalNums++;
        }
        double avg = total/totalNums;
        return avg;
    }
    public static void main(String[] args) {
        // Test method with given numbers.
        double avg = average(10, 8, 10);
        System.out.println("Average of your numbers: " + avg);

        // Test method with given array.
        double[] scores = {100, 90, 80, 100, 80};
        avg = average(scores);
        System.out.println("Average of your numbers: " + avg);

        // Test method with user inputted array.
        System.out.print("How many numbers do you think you'd to take an average of? ");
        Scanner scan = new Scanner(System.in);
        int length = scan.nextInt() + 2; // give users 2 extra elements in case.
        double[] numsToAverage = new double[length];
        length = getTestScores(scan, numsToAverage);
        double[] clippedArray = Arrays.copyOf(numsToAverage, length);
        avg = average(clippedArray);
        System.out.println("Average of your numbers: " + avg);
    }
}