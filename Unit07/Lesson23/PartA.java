import java.util.Scanner;

public class PartA {
    public static int getQuizScore(Scanner in) {
        System.out.print("Enter a quiz score: ");
        int quizScore = in.nextInt();
        if (quizScore < 0 || quizScore > 100) {
            throw new ArithmeticException("Score must be between 0 and 100.");
        } else {
            return quizScore;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean errorFound = false;
        while (errorFound == false) {
            try {
                int score = getQuizScore(in);
                System.out.println("score = " + score);
            } catch (Exception e) {
                System.err.println("an error occurred!");
                System.out.println(e.getMessage());
                errorFound = true;
            }
        }
        in.close();
    }
}