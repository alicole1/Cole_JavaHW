// Ali Cole AT Java
// AT 05: Intro to Object Oriented Programming
// Part A

// import Random Class
import java.util.Random;

public class PartA {
    public static void main(String[] args) {
        // Create new object
        Random random = new Random();

        // loops 100 times
        for (int i=0; i<100; i++) {

            // creates a random int form 0 (inclusive) to 100 (exclusive)
            int randNum = random.nextInt(100);
            // prints the int to standard output
            System.out.println(randNum);
        }
        
    }
}