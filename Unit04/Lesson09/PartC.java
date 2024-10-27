// Ali Cole AT Java
// Lesson 09: Using Loops
// Part C

public class PartC {
    public static void main(String[] args) {
        // Declare the variables we will use.
        int rand = 0; // The individual random number.
        int total = 0; // The total of all numbers so far.
        
        // CALCULATE AVERAGE OF LOOPING THROUGH RANDOM INTEGERS FROM 1 - 10 10 TIMES.
        for (int i = 0; i<=10; i++) {
            // Use formula: (int) (Math.random() * (b - a + 1)) + a where a is 1 and b is 10.
            // (int) (Math.random() * (10 - 1 + 1)) + 1.
            rand = (int) (Math.random() * 10) + 1;
            total = total + rand; // Add new number to total value thus far.
        }
        // Find average by dividing by number of times run (10).
        int avg = total / 10;
        // Display information to user.
        System.out.println("the average after looping 10 times is " + avg);


        // CALCULATE AVERAGE OF LOOPING THROUGH RANDOM INTEGERS FROM 1 - 10 1000 TIMES.
        for (int i = 0; i<=1000; i++) {
            rand = (int) (Math.random() * 10) + 1;
            total = total + rand;
        }
        // Find average by dividing by number of times run (10).
        avg = total / 1000;
        // Display information to user.
        System.out.println("the average after looping 1000 times is " + avg);

        /* 
        * REFLECTION: the average of 5 does make sense (particularly the average after 1000 loops)
        * because the most "middle number" is 5. Halfway in between 1 and 10 is 5, so any number the programs returns
        * will either be 5, a little over 5, or a little under 5.
        * With more data points (1000 loops) we see this number much more consistently.
        */
    }
}
