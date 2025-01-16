// Ali Cole
// Lesson 20 - Text Input and Output
// Part B

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PartB {
    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File("characters.txt");
        Scanner in = new Scanner(inputFile);
        in.useDelimiter("");

        // Loop through file information, print, and count numbers and letters.
        int charCount = 0;
        int letterCount = 0;
        int digitCount = 0;

        while (in.hasNext()) {
            Character currentChar = in.next().charAt(0);
            if (currentChar.isLetter(currentChar) == true) {
                letterCount++;
            } else if (currentChar.isDigit(currentChar) == true) {
                digitCount++;
            }
            charCount++;
            System.out.print(currentChar);
        }

        System.out.println("count = " + charCount);
        System.out.println("letters = " + letterCount);
        System.out.println("digits = " + digitCount);

        in.close();
    }
}
