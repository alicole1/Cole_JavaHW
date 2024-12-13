
import java.util.Arrays;

public class PartC {
    public static int linearSearch(int[] array, int tgtVal) {
        int tgtPresAt = -1;
        int i = 0;
        while ((tgtPresAt == -1) && (i<array.length)) {
            if (array[i] == tgtVal) {
                tgtPresAt = i;
            } else {
                i++;
            }
        }  
        return tgtPresAt;
    } 
    public static void main(String[] args) {
        // Collects user information to create original array.
        final int LENGTH = 10000; // Can be set to any int to change orig length of array.
        int[] values = new int[LENGTH];
        int currentSize = 0; // Tracks how much of the array we are actually using.
        while(true) { 
            values[currentSize] = (int)(Math.random()*LENGTH) + 1;
            currentSize++;
            if (currentSize==values.length) {
                break;
            }
        }
        for (int i = 0; i < 10; i++) {
            int target = (int)(Math.random()*LENGTH) +1;
            // int prevTime = System.currentTimeMillis();

            int tgtPresAt = linearSearch(values, target);
            if (tgtPresAt == -1) {
                System.err.println("Oops! Linear search could not find target " + target);
            } else {
                System.out.println("Linear search found target " + target + " at position " + tgtPresAt + " in array. Time to complete linear search: " + System.currentTimeMillis() + " milliseconds");
            }
            
            Arrays.sort(values, 0, values.length); // Sorts from low to high.
            tgtPresAt = Arrays.binarySearch(values, target);

            if (tgtPresAt < 0) {
                System.err.println("Oops! Binary search could not find target " + target);
            } else {
                System.out.printf("Binary search found target " + target + " at position " + tgtPresAt + " in array. Time to complete binary search: " + System.currentTimeMillis() + " milliseconds %n%n");
            }
        }

    }
}
