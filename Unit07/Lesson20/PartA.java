// Ali Cole
// Lesson 20 - Text Input and Output
// Part A

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PartA {
    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File("customerdata.txt");
        Scanner in = new Scanner(inputFile);
        in.useDelimiter("[, \n]");

        System.out.printf(
                "---------------------------------------%n   ID  |    Name     |     Balance %n---------------------------------------%n");

        // Loop through file information and print.
        while (in.hasNext()) {
            if (in.hasNextInt()) {
                System.out.printf("%06d | ", in.nextInt());
            } else if (in.hasNextDouble()) {
                System.out.printf(" $%,15.2f %n", in.nextDouble());
            } else {
                in.next();
                System.out.printf("%11s |", in.next());
                in.next();
            }
        }
        in.close();
    }
}
