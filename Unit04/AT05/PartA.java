// Ali Cole AT Java
// AT05: Intro to Object-Oriented Programming
// Part A

// Import java class
import java.util.Random;

public class PartA {
    public static void main(String[] args) {
        // Declare method
        Random random = new Random();

        // Run 100 times
        for (int i=0; i<100; i++) {
            int randNum = random.nextInt(100);
            System.out.println(randNum);
        }
        
    }
}