import java.util.Arrays;
import java.util.Scanner;

public class PartA {
    // Method that takes the positions of the elements being swapped, and the array they are part of.
    // Swaps the two elements.
    // As arrays are not primative variables, this change will be reflected in main code as well.
    public static void swap(int firstPos, int secondPos, int[] inputArray) {
        int i = firstPos;
        int j = secondPos;
        int[] array = inputArray;
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // Main code.
    public static void main(String[] args) {

        // Collects user information to create original array.
        final int LENGTH = 10; // Can be set to any int to change orig length of array.
        int[] values = new int[LENGTH];
        int currentSize = 0; // Tracks how much of the array we are actually using.
        Scanner scan = new Scanner(System.in);
        while(true) { 
            System.out.print("Enter a test score or 'q' to quit: ");
            if ((scan.hasNextInt()) && (currentSize < values.length)){
                    values[currentSize] = scan.nextInt();
                    currentSize++;
            } else if (scan.hasNext("q") || scan.hasNext("Q")) {
                scan.next();
                break;
            } else {
                System.err.println("Oops! Cannot accept; array is at max volume. :(");
                break;
            }
        }

        scan.close();

        // Displays original array to user with * in between.
        System.out.println("-------------------------");
        for (int i = 0; i < currentSize; i++) {
            if (i == 0) {
                System.out.print("*");
            }

            System.out.print(values[i] + "*");

            if (i == (currentSize-1)) {
                System.out.printf("%n");
            }
        }

        // Sorts the array into reverse numerical order.
        Arrays.sort(values, 0, currentSize); // Sorts from low to high.
        int start = -1; // Sets start position (-1). 
        int end = currentSize; // Sets end position (+1).
        // Starts with outside elements, swaps. Then slowly moves inwards, until we're at middle of array.
        for (int magNum = 1; (magNum <= currentSize / 2); magNum++) {
            swap(start+magNum,end-magNum,values); 
        }
 
        // Displays sorted array to user with commas in between.
        for (int i = 0; i < currentSize; i++) {
            if (i == (currentSize-1)) {
                System.out.println(values[i]);
            } else {
                System.out.print(values[i] + ",");
            }
        }
    }
}