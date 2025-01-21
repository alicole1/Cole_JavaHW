import java.util.ArrayList;
import java.util.Scanner;

public class PartB {

    /**
     * Method: fills an array with test scores. returns the average of all scores
     * entered
     */
    public static double fillArray(Scanner scan, ArrayList<Double> scores) {
        // declares variables to be called.
        double score; // stores current score entered.
        double total = 0; // stores total of scores. (for avg calc)
        int scoresAdded = 0; // stores total numbers of scores. (for avg calc)
        double average; // will store final average.
        String input = ""; // will store input.
        while (true) {
            System.out.print("Enter a quiz score or 'q' to quit: ");

            if (scan.hasNextDouble()) {
                // add score to array and update doubles.
                score = scan.nextDouble();
                total = total + score;
                scores.add(score);
                scoresAdded++;
            } else if (scan.hasNext()) {
                // check if user wants to quit.
                input = scan.next();
                if (input.toLowerCase().equals("q")) {
                    average = total / scoresAdded;
                    return average;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        // declare and initialize scan and arraylist objects.
        Scanner scan = new Scanner(System.in);
        ArrayList<Double> scores = new ArrayList<>();

        // call method.
        double average = fillArray(scan, scores);

        // display new array and average to user in terminal.
        System.out.println("-------------------");
        for (int i = 0; i < scores.size(); i++) {
            System.out.printf("%8.2f %n", scores.get(i));
        }
        System.out.println("-------------------");
        System.out.printf("avg = %.2f %n", average);
    }
}
