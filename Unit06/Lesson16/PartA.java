import java.util.Scanner;

public class PartA {

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
    
    // METHOD: finds index of lowest val.
    public static int findLowest(double[] arr, int length) {
        double[] testScores = arr;
        int len = length;
        double lowestVal = testScores[0];
        int lowestIndex = 0;
        for (int i = 0; i < len; i++) {
            if (testScores[i] < lowestVal) {
                lowestVal = testScores[i];
                lowestIndex = i;
            }
        }
        return lowestIndex;
    }

    /** 
     * METHOD: drops a val from an array.
     */
    public static int dropFromArray(double[] arr, int index, int length) {
        double[] testScores = arr;
        int startDex = index;
        int len = length;

        for (int i = startDex; i < len-1; i++) {
            testScores[i] = testScores[i+1];
        }
        len = len-1;
        return len;
    }

    public static void main(String[] args) {
        /* 
         * Set up and initialize filled array.
         */
        final int LENGTH = 20; // Can be set to any int to change orig length of array.
        Scanner scanner = new Scanner(System.in);

        double[] scores = new double[LENGTH]; // Creates new array to be filled.
        int length = getTestScores(scanner, scores); // Calls method to fill array.

        /*
         * Display test scores.
         */
        System.out.printf("%n%n Test Scores: %n ------------------ %n");
        for (int i = 0; i < length; i++) {
            System.out.println(" | " + scores[i] + " | ");
        }

        /*
         * Drop lowest test score if user wants.
         */
        System.out.print("Would you like to drop the lowest score? (y/n) ");
        String userInput = scanner.nextLine().toLowerCase();
        
        if (userInput.equals("y")) {
            System.out.println("User wants to drop! :o");
            int lowestIndex = findLowest(scores, length);
            System.out.println("Lowest val is found at: " + lowestIndex);
            length = dropFromArray(scores, lowestIndex, length);
        }
        
        /*
         * Display test scores.
         */
        System.out.printf("%n%n Test Scores: %n ------------------ %n");
        for (int i = 0; i < length; i++) {
            System.out.println(" | " + scores[i] + " | ");
        }
    }
}