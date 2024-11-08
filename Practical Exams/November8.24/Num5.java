public class Num5 {
    public static void main(String[] args) {
        // Declare and initialize variables.
        int currentNum = 0; // Current number we are on. (1, 2, 3, 4, 5...).
        double total = 0.0; // Running total of all numbers thus far. Must be a double so that average doesn't become an int and we lose info. 
        int count = 0; // Total number of numbers we've added. Technically, we could just make this 100, but this way we can make it variable to quickly test to find averages other than 1-100.
        double avg = 0.0; // Final average.

        // Loop! Finds the sum of all num 1-100, and counter.
        for (int i = 0; i<100; i++) {
            currentNum++; // Adds 1 to current number. First round this makes currentNum 1, second this makes currentNUm 2, ... up until it = 100.
            // TROUBLESHOOTING: System.out.println(currentNum);
            total = total + currentNum; // Adds current num to total.
            count++; // Adds one to count. 
        }
        avg = total / count; // Calculate average. 
        System.out.println("The average is " + avg); // Display average to user.
    }
}