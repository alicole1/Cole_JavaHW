// Ali Cole
// Lesson 19 - Reading and Writing Text Files
// Part B

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class PartB {
    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File("quizzes.txt");
        Scanner in = new Scanner(inputFile);

        File outputFile = new File("quizzesMod.txt");
        PrintWriter out = new PrintWriter(outputFile);

        int currentQuizNum = 0;
        double total = 0;

        while (in.hasNext()) {
            double score = in.nextDouble();
            total = total + score;
            out.printf("Quiz %03d: %6.2f%n", currentQuizNum, score);
            currentQuizNum++;
        }
        out.println("----------------");
        double average = total / currentQuizNum;
        out.printf("Average: %7.2f%n", average);
        in.close();
        out.close();
    }
}
