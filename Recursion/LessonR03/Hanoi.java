import java.util.Scanner;

public class Hanoi {
    public static void hanoi(int n, int start, int end) {
        int interim = getInterim(start, end);
        if (n == 3) {
            printMove(start, end); // smallest to end
            printMove(start, interim); // middle to interim
            printMove(end, interim); // smallest to interim
            printMove(start, end); // largest to end
            printMove(interim, start); // smallest to start
            printMove(interim, end); // middle to end
            printMove(start, end); // smallest to end
        } else {
            hanoi(n - 1, start, interim);
            printMove(start, end);
            hanoi(n - 1, interim, end);
        }
    }

    public static int getInterim(int start, int end) {
        if (start == 1 && end == 2 || start == 2 && end == 1) {
            // System.out.printf("start = %d, end = %d, interim is %d%n", start, end, 3);
            return 3;
        } else if (start == 1 && end == 3 || start == 3 && end == 1) {
            // System.out.printf("start = %d, end = %d, interim is %d%n", start, end, 2);
            return 2;
        } else {
            // System.out.printf("start = %d, end = %d, interim is %d%n", start, end, 1);
            return 1;
        }
    }

    public static void printMove(int start, int end) {
        System.out.printf("%d -> %d%n", start, end);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = 0;
        String input = "";
        while (!input.equals("q")) {
            System.out.print("Enter an integer > 2 or q to quit: ");
            input = in.nextLine();
            if (input.toLowerCase().equals("q")) {
                System.out.println("Goodbye!");
                return;
            } else {
                n = Integer.parseInt(input);
            }
            hanoi(n, 1, 3);
        }
    }
}
